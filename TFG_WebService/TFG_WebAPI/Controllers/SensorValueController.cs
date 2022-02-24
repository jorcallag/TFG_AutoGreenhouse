using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TFG_WebAPI.Models;

namespace TFG_WebAPI.Controllers
{
    public class SensorValueController : ApiController
    {
        DatabaseConnections DB = new DatabaseConnections();

        [HttpGet]
        // GET api/Get/SensorValue/Id/{id}
        [Route("api/Get/SensorValue/Id/{id}")]
        public sensor_value GetSensorValueId(int id)
        {
            var sensor_value = DB.sensor_value.FirstOrDefault(x => x.id_sensor_value == id);
            return sensor_value;
        }

        // GET api/Get/SensorValue/BySensor/Id/{id}
        [Route("api/Get/SensorValue/BySensor/Id/{id}")]
        public sensor_value GetSensorValueBySensorId(int id)
        {
            var sensor_values = DB.sensor.FirstOrDefault(x => x.id_sensor == id).sensor_value;
            var sensor_value = sensor_values.Last();
            return sensor_value;
        }

        [HttpPost]
        // POST api/Post/SensorValue/
        [Route("api/Post/SensorValue/")]
        public void PostSensorValue([FromBody] sensor_value value)
        {
            DB.sensor_value.Add(value);
            DB.SaveChanges();
        }

        [HttpPut]
        // PUT api/Put/SensorValue/Id/{id}
        [Route("api/Put/SensorValue/Id/{id}")]
        public void PutSensorValueId(int id, [FromBody] sensor_value value)
        {
            var sensor_value = DB.sensor_value.FirstOrDefault(x => x.id_sensor_value == id);

            if (sensor_value != null)
            {
                sensor_value.value = value.value;
                sensor_value.timestamp = value.timestamp;
                sensor_value.id_sensor_associated = value.id_sensor_associated;
                DB.SaveChanges();
            }
        }

        [HttpDelete]
        // DELETE api/Delete/SensorValue/{id}
        [Route("api/Delete/SensorValue/Id/{id}")]
        public void DeleteSensorValueId(int id)
        {
            var sensor_value = DB.sensor_value.FirstOrDefault(x => x.id_sensor_value == id);

            if (sensor_value != null)
            {
                DB.sensor_value.Remove(sensor_value);
                DB.SaveChanges();
            }
        }
    }
}