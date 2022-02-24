using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TFG_WebAPI.Models;

namespace TFG_WebAPI.Controllers
{
    public class SensorController : ApiController
    {
        DatabaseConnections DB = new DatabaseConnections();

        [HttpGet]
        // GET api/Get/Sensor/Id/{id}
        [Route("api/Get/Sensor/Id/{id}")]
        public sensor GetSensorId(int id)
        {
            var sensor = DB.sensor.FirstOrDefault(x => x.id_sensor == id);
            return sensor;
        }

        // GET api/Get/Sensors/ByDevice/Id/{id}
        [Route("api/Get/Sensors/ByDevice/Id/{id}")]
        public ICollection<sensor> GetSensorsByDeviceId(int id)
        {
            var sensors = DB.device.FirstOrDefault(x => x.id_device == id).sensor;
            return sensors;
        }

        [HttpPost]
        // POST api/Post/Sensor/
        [Route("api/Post/Sensor/")]
        public void PostSensor([FromBody] sensor value)
        {
            DB.sensor.Add(value);
            DB.SaveChanges();
        }

        [HttpPut]
        // PUT api/Put/Sensor/{id}
        [Route("api/Put/Sensor/{id}")]
        public void PutSensorId(int id, [FromBody] sensor value)
        {
            var sensor = DB.sensor.FirstOrDefault(x => x.id_sensor == id);

            if (sensor != null)
            {
                sensor.type = value.type;
                sensor.name = value.name;
                sensor.description = value.description;
                sensor.id_device_associated = value.id_device_associated;
                DB.SaveChanges();
            }
        }

        [HttpDelete]
        // DELETE api/Delete/Sensor/{id}
        [Route("api/Delete/Sensor/{id}")]
        public void DeleteSensorId(int id)
        {
            var sensor = DB.sensor.FirstOrDefault(x => x.id_sensor == id);

            if (sensor != null)
            {
                DB.sensor.Remove(sensor);
                DB.SaveChanges();
            }
        }
    }
}