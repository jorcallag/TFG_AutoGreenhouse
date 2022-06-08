#include <Arduino_JSON.h>
#include <WiFi.h>
#include <HTTPClient.h>
#include "DHT.h"

//Declaracion de funciones
void getPlanta(void *pvParameters);
void postSensorValue(float sample, int idSensor);
void postActuatorValue(bool execution, int idActuator);

void dhtSensorRead(void *pvParameters);
void ldrSensorRead(void *pvParameters);
void groundHumidSensorRead(void *pvParameters);
void liquidSensorRead(void *pvParameters);

void irrigationSystem(void *pvParameters);
void temperatureControlSystem(void *pvParameters);
void humidityControlSystem(void *pvParameters);
void lightControlSystem(void *pvParameters);
void fertilizerIrrigationSystem(void *pvParameters);
void warningSystem(void *pvParameters);

//Declaracion de ids de sensores
const int idAirTempSensor = 1;
const int idAirHumidSensor = 2;
const int idGroundHumidSensor = 3;
const int idLightSensor = 4;
const int idFertilizerLiquidSensor = 5;
const int idHumidLiquidSensor = 6;

//Declaracion de ids de actuadores
const int idLedsActuator = 1;
const int idValveActuator = 2;
const int idPumpActuator = 3;
const int idExtractActuator = 4;
const int idHeatingActuator = 5;
const int idHumidActuator = 6;

//Declaracion de pines de sensores
const int pinDht11Sensor = 36;
const int pinGroundHumidSensor = 39;
const int pinLdrSensor = 34;
const int pinFertilizerLiquidSensor = 35;
const int pinHumidLiquidSensor = 32;

//Declaracion de pines de actuadores
const int pinLedsActuator = 33;
const int pinValveActuator = 25;
const int pinPumpActuator = 26;
const int pinExtractActuator = 27;
const int pinHeatingActuator = 14;
const int pinHumidActuator = 12;
const int pinBuzzerActuator = 13;

//Declaracion de variables necesarias para pwm
const int freq = 5000;
const int channel0 = 0;
const int channel1 = 1;
const int channel2 = 3;
const int resolution = 8;

//Declaracion de variables de medidas
double lightSample = 0;
double airTempSample = 0;
double airHumidSample = 0;
double groundHumidSample = 0;
double fertilizerTankSample = 0;
double humidTankSample = 0;

//Declaracion de variables de la planta
double airTempNecessary = 0; 
double airHumidNecessary = 0; 
double groundHumidNecessary = 0; 
double fertilizerWeekNecessary = 0; 

//Declaracion de variables para el correcto funcionamiento de la conexion
WiFiClient client;
String SSID = "DIGIFIBRA-tz9F";
String PASS = "eXRHUdCFRU";
String serverName = "http://autogreenhouse.azurewebsites.net";

DHT dht(pinDht11Sensor, DHT11);

void setup() {
  //Inicializacion del puerto Serial
  Serial.begin(9600);

  //Iniciamos la conexion
  WiFi.begin(SSID.c_str(), PASS.c_str());
  Serial.printf("Conectando...");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.printf(".");
  }
  Serial.print("Exito al conectar, IP address: ");
  Serial.println(WiFi.localIP());

  //Inicializacion de pines de sensores
  pinMode(pinDht11Sensor, INPUT);                 
  pinMode(pinGroundHumidSensor, INPUT);         
  pinMode(pinLdrSensor, INPUT);                  
  pinMode(pinFertilizerLiquidSensor, INPUT);      
  pinMode(pinHumidLiquidSensor, INPUT);      

  //Inicializacion de pines de actuadores        
  pinMode(pinValveActuator, OUTPUT);    
  pinMode(pinPumpActuator, OUTPUT);             
  pinMode(pinHeatingActuator, OUTPUT);    
  pinMode(pinHumidActuator, OUTPUT);  

  //Inicializamos canales pwm para actuadores que lo requieran
  ledcSetup(channel0, freq, resolution);
  ledcAttachPin(pinBuzzerActuator, channel0);
  ledcSetup(channel1, freq, resolution);
  ledcAttachPin(pinExtractActuator, channel1);
  ledcSetup(channel2, freq, resolution);
  ledcAttachPin(pinLedsActuator, channel2);

  dht.begin();

  xTaskCreate(warningSystem, "warningSystem", 1024, NULL, 4, NULL);
  xTaskCreate(fertilizerIrrigationSystem, "fertilizerIrrigationSystem", 1024, NULL, 3, NULL);
  xTaskCreate(lightControlSystem, "lightControlSystem", 1024, NULL, 3, NULL);
  xTaskCreate(humidityControlSystem, "humidityControlSystem", 1024, NULL, 3, NULL);
  xTaskCreate(temperatureControlSystem, "temperatureControlSystem", 1024, NULL, 3, NULL);
  xTaskCreate(irrigationSystem, "irrigationSystem", 1024, NULL, 3, NULL);
  xTaskCreate(liquidSensorRead, "liquidSensorRead", 1024, NULL, 2, NULL);
  xTaskCreate(groundHumidSensorRead, "groundHumidSensorRead", 1024, NULL, 2, NULL);
  xTaskCreate(ldrSensorRead, "ldrSensorRead", 1024, NULL, 2, NULL);
  xTaskCreate(dhtSensorRead, "dhtSensorRead", 2048, NULL, 2, NULL);
  xTaskCreate(getPlanta, "getPlanta", 1024, NULL, 1, NULL);
}

void loop() {

}

void warningSystem(void *pvParameters){
  for(;;){
    if(fertilizerTankSample == 0){
      ledcWriteTone(channel0, 255);
      vTaskDelay(2000); 
      ledcWriteTone(channel0, 0);      
      vTaskDelay(2000);
    }else{
      ledcWriteTone(channel0, 0);
    }
    if(humidTankSample == 0){
      ledcWriteTone(channel0, 255);
      vTaskDelay(2000);
      ledcWriteTone(channel0, 0);      
      vTaskDelay(2000);
    }else{
      ledcWriteTone(channel0, 0);
    }
  }
}

void fertilizerIrrigationSystem(void *pvParameters){
  for(;;){
    digitalWrite(pinPumpActuator, LOW);
    postActuatorValue(1, idPumpActuator);
    vTaskDelay(((fertilizerWeekNecessary*3600)/350)*1000);
    digitalWrite(pinPumpActuator, HIGH);
    postActuatorValue(0, idPumpActuator);
    vTaskDelay(7 * 24 * 60 * 60 * 1000);
  }
}

void lightControlSystem(void *pvParameters){
  for(;;){
    int dutyCycle = 255-(lightSample*2.55);
    ledcWrite(channel2, dutyCycle);
    postActuatorValue(1, idLedsActuator);
  }
}

void humidityControlSystem(void *pvParameters){
  for(;;){
    if(airHumidSample < airHumidNecessary){
      digitalWrite(pinHumidActuator, LOW);
      postActuatorValue(1, idHumidActuator);
    }else{
      digitalWrite(pinHumidActuator, HIGH);
      postActuatorValue(0, idHumidActuator);
    }    
  }
}

void temperatureControlSystem(void *pvParameters){
  for(;;){
    if(airTempSample < airTempNecessary){
      digitalWrite(pinHeatingActuator, LOW);
      postActuatorValue(1, idHeatingActuator);
      ledcWrite(channel1, 0);
      postActuatorValue(0, idExtractActuator);
    }else if(airTempSample > airTempNecessary){
      ledcWrite(channel1, (airTempSample-airTempNecessary)*25);
      postActuatorValue(1, idExtractActuator);
      digitalWrite(pinHeatingActuator, HIGH);
      postActuatorValue(0, idHeatingActuator);
    }
  }
}

void irrigationSystem(void *pvParameters){
  for(;;){
    if(groundHumidSample < groundHumidNecessary){
      digitalWrite(pinValveActuator, LOW);
      postActuatorValue(1, idValveActuator);
    }else{
      digitalWrite(pinValveActuator, HIGH);
      postActuatorValue(0, idValveActuator);
    }  
  }
}

void liquidSensorRead(void *pvParameters){
  for(;;){
    if(digitalRead(pinFertilizerLiquidSensor) != 0){
      fertilizerTankSample = 100;
      postSensorValue(fertilizerTankSample, idFertilizerLiquidSensor);
    }else{
      fertilizerTankSample = 0;
      postSensorValue(fertilizerTankSample, idFertilizerLiquidSensor);
    }
    
    if(digitalRead(pinHumidLiquidSensor) != 0){
      humidTankSample = 100;
      postSensorValue(humidTankSample, idHumidLiquidSensor);
    }else{
      humidTankSample = 0;
      postSensorValue(humidTankSample, idHumidLiquidSensor);
    }
    vTaskDelay(30 * 60 * 1000);
  }
}

void groundHumidSensorRead(void *pvParameters){
  for(;;){
    groundHumidSample = (100-((100*analogRead(pinGroundHumidSensor))/4095));
    postSensorValue(groundHumidSample, idGroundHumidSensor);
    vTaskDelay(30 * 60 * 1000);
  }
}

void ldrSensorRead(void *pvParameters){
  for(;;){
    lightSample = (100*analogRead(pinLdrSensor))/4095;
    postSensorValue(lightSample, idLightSensor);
    vTaskDelay(30 * 60 * 1000);
  }
}

void dhtSensorRead(void *pvParameters){
  for(;;){
    airHumidSample = dht.readHumidity();
    postSensorValue(airHumidSample, idAirHumidSensor);
    vTaskDelay(10);
    airTempSample = dht.readTemperature();
    postSensorValue(airTempSample, idAirTempSensor);
    vTaskDelay(30 * 60 * 1000);
  }
}

void getPlanta(void *pvParameters){
  for(;;){
    if(WiFi.status() == WL_CONNECTED){
      HTTPClient http;
  
      String serverPath = serverName + "/api/Get/Plant/Id/1";
      http.begin(serverPath.c_str());
      
      int httpResponseCode = http.GET();
  
      if (httpResponseCode>0) {
        Serial.print("HTTP Response code: ");
        Serial.println(httpResponseCode);
      }
      else{
        Serial.print("Error code: ");
        Serial.println(httpResponseCode);
      }
      
      String payload = http.getString();
  
      JSONVar myObject = JSON.parse(payload);
    
      if (JSON.typeof(myObject) == "undefined") {
        Serial.println("Parsing input failed!");
        return;
      }
      
      JSONVar keys = myObject.keys();
      airTempNecessary = myObject[keys[5]];
      airHumidNecessary = myObject[keys[6]];
      groundHumidNecessary = myObject[keys[7]];
      fertilizerWeekNecessary = myObject[keys[8]];
      http.end();
  
    }
    vTaskDelay(30 * 60 * 1000);
  }
}

void postSensorValue(float sample, int idSensor){
  if (WiFi.status() == WL_CONNECTED){
    HTTPClient http;
    
    String serverPath = serverName + "/api/Post/SensorValue";
    http.begin(serverPath.c_str());
      
    http.addHeader("Content-Type", "application/json");
    int httpResponseCode = http.POST("{\"id_sensor_associated\":\"" + String(idSensor) + "\",\"value\":\"" + String(sample) + "\"}");
  
    if (httpResponseCode>0) {
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
    }
    else{
      Serial.print("Error code: ");
      Serial.println(httpResponseCode);
    }
        
    http.end();
  } 
}

void postActuatorValue(int execution, int idActuator){
  if (WiFi.status() == WL_CONNECTED){
    HTTPClient http;
    
    String serverPath = serverName + "/api/Post/ActuatorValue";
    http.begin(serverPath.c_str());
       
    http.addHeader("Content-Type", "application/json");
    int httpResponseCode = http.POST("{\"id_actuator_associated\":\"" + String(idActuator) + "\",\"execution\":\"" + String(execution) + "\"}");
 
    if (httpResponseCode>0) {
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
    }
    else{
      Serial.print("Error code: ");
      Serial.println(httpResponseCode);
    }
         
    http.end();
  }
}
