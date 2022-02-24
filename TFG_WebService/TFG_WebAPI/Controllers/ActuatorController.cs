using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TFG_WebAPI.Models;

namespace TFG_WebAPI.Controllers
{
    public class ActuatorController : ApiController
    {
        DatabaseConnections DB = new DatabaseConnections();

        [HttpGet]
        // GET api/Get/Actuator/Id/{id}
        [Route("api/Get/Actuator/Id/{id}")]
        public actuator Get(int id)
        {
            var actuator = DB.actuator.FirstOrDefault(x => x.id_actuator == id);
            return actuator;
        }

        // GET api/Get/Actuators/ByDevice/Id/{id}
        [Route("api/Get/Actuators/ByDevice/Id/{id}")]
        public ICollection<actuator> GetActuatorByDeviceId(int id)
        {
            var actuators = DB.device.FirstOrDefault(x => x.id_device == id).actuator;
            return actuators;
        }

        [HttpPost]
        // POST api/Post/Actuator/
        [Route("api/Post/Actuator/")]
        public void Post([FromBody] actuator value)
        {
            DB.actuator.Add(value);
            DB.SaveChanges();
        }

        [HttpPut]
        // PUT api/Put/Actuator/Id/{id}
        [Route("api/Put/Actuator/Id/{id}")]
        public void Put(int id, [FromBody] actuator value)
        {
            var actuator = DB.actuator.FirstOrDefault(x => x.id_actuator == id);

            if (actuator != null)
            {
                actuator.type = value.type;
                actuator.name = value.name;
                actuator.description = value.description;
                actuator.id_device_associated = value.id_device_associated;
                DB.SaveChanges();
            }
        }

        [HttpDelete]
        // DELETE api/Delete/Actuator/Id/{id}
        [Route("api/Delete/Actuator/Id/{id}")]
        public void Delete(int id)
        {
            var actuator = DB.actuator.FirstOrDefault(x => x.id_actuator == id);

            if (actuator != null)
            {
                DB.actuator.Remove(actuator);
                DB.SaveChanges();
            }
        }
    }
}

