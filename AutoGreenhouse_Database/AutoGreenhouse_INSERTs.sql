/*Plant*/

Insert into plant (name, description, air_temperature, air_humidity, ground_humidity, quantity_fertilizer_week, id_device_associated) values ('Rosal', 'Los rosales son una especie de arbusto espinoso de la familia de las rosáceas.', 20, 15, 50, 3, 1)

/*Device*/

Insert into device (name, password, id_plant_associated) values ('FREDD', '0454', 1)


/*Actuator*/

Insert into actuator (type, name, description, id_device_associated) values ('Luminosidad', 'LEDs', 'Dispositivo encargado de proporcionar la luz necesaria a la planta', 1)
Insert into actuator (type, name, description, id_device_associated) values ('Hidratacion', 'Electrovalvula', 'Dispositivo encargado de proporcionar riego para que la tierra donde se encuentra la planta se mantenga con la humedad perfeta', 1)
Insert into actuator (type, name, description, id_device_associated) values ('Fertilizancion', 'Bomba', 'Dispositivo encargado de proporcionar el fertilizante necesario a la planta', 1)
Insert into actuator (type, name, description, id_device_associated) values ('Extraccion', 'Ventilador', 'Dispositivo encargado de regular la temperatura, en concreto se encarga de extraer calor del habitaculo', 1)
Insert into actuator (type, name, description, id_device_associated) values ('Calefaccion', 'Malla calefactora', 'Dispositivo encargado de regular la temperatura, en concreto se encarga de proporcionar calor al habitaculo', 1)
Insert into actuator (type, name, description, id_device_associated) values ('Humidificacion', 'Humidicicador', 'Dispositivo encargado de proporcionar humedad al habitaculo', 1)


/*ActuadorValue*/

Insert into actuator_value (execution, timestamp, id_actuator_associated) values (0, '2022-02-28T12:00:00.0000000', 1)
Insert into actuator_value (execution, timestamp, id_actuator_associated) values (0, '2022-02-28T12:00:00.0000000', 2)
Insert into actuator_value (execution, timestamp, id_actuator_associated) values (0, '2022-02-28T12:00:00.0000000', 3)
Insert into actuator_value (execution, timestamp, id_actuator_associated) values (0, '2022-02-28T12:00:00.0000000', 4)
Insert into actuator_value (execution, timestamp, id_actuator_associated) values (0, '2022-02-28T12:00:00.0000000', 5)
Insert into actuator_value (execution, timestamp, id_actuator_associated) values (0, '2022-02-28T12:00:00.0000000', 6)


/*Sensor*/

Insert into sensor (type, name, description, id_device_associated) values ('Temperatura ambiente', 'DHT11 temperatura ambiente', 'Sensor encargado de leer la temperatura del habitaculo', 1)
Insert into sensor (type, name, description, id_device_associated) values ('Humedad ambiente', 'DHT11 humedad ambiente', 'Sensor encargado de leer la humedad del habitaculo', 1)
Insert into sensor (type, name, description, id_device_associated) values ('Humedad tierra', 'Sensor de humedad tierra', 'Sensor encargado de leer la humedad de la tierra', 1)
Insert into sensor (type, name, description, id_device_associated) values ('Luminosidad', 'LDR', 'Sensor encargado de leer la luminosidad', 1)
Insert into sensor (type, name, description, id_device_associated) values ('Nivel de liquidos', 'Nivel de liquidos tanque fertilizante', 'Sensor encargado de leer el nivel de liquido del tanque de fertilizante', 1)
Insert into sensor (type, name, description, id_device_associated) values ('Nivel de liquidos', 'Nivel de liquidos tanque humidificador', 'Sensor encargado de leer el nivel de liquido del tanque del humidificador', 1)


/*SensorValue*/

Insert into sensor_value (value, timestamp, id_sensor_associated) values (19, '2022-02-28T12:00:00.0000000', 1)
Insert into sensor_value (value, timestamp, id_sensor_associated) values (25, '2022-02-28T12:00:00.0000000', 2)
Insert into sensor_value (value, timestamp, id_sensor_associated) values (50, '2022-02-28T12:00:00.0000000', 3)
Insert into sensor_value (value, timestamp, id_sensor_associated) values (70, '2022-02-28T12:00:00.0000000', 4)
Insert into sensor_value (value, timestamp, id_sensor_associated) values (100, '2022-02-28T12:00:00.0000000', 5)
Insert into sensor_value (value, timestamp, id_sensor_associated) values (0, '2022-02-28T12:00:00.0000000', 6)
