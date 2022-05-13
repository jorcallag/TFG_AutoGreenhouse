using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TFG_WebAPI.Models;

namespace TFG_WebAPI.Controllers
{
    public class ActuatorValueController : ApiController
    {
        autogreenhousedbEntities1 DB = new autogreenhousedbEntities1();

        [HttpGet]
        // GET api/Get/ActuatorValue/Id/{id}
        [Route("api/Get/ActuatorValue/Id/{id}")]
        public actuator_value GetActuatorValueId(int id)
        {
            var actuator_value = DB.actuator_value.FirstOrDefault(x => x.id_actuator_value == id);
            return actuator_value;
        }

        // GET api/Get/ActuatorValue/ByActuator/Id/{id}
        [Route("api/Get/ActuatorValue/ByActuator/Id/{id}")]
        public actuator_value GetActuatorValueByActuatorId(int id)
        {
            var actuator_values = DB.actuator.FirstOrDefault(x => x.id_actuator == id).actuator_value;
            var actuator_value = actuator_values.Last();
            return actuator_value;
        }

        [HttpPost]
        // POST api/Post/ActuatorValue/
        [Route("api/Post/ActuatorValue/")]
        public void PostActuatorValue([FromBody] actuator_value value)
        {
            DB.actuator_value.Add(value);
            DB.SaveChanges();
        }

        [HttpPut]
        // PUT api/Put/ActuatorValue/Id/{id}
        [Route("api/Put/ActuatorValue/Id/{id}")]
        public void PutActuatorValueId(int id, [FromBody] actuator_value value)
        {
            var actuator_value = DB.actuator_value.FirstOrDefault(x => x.id_actuator_value == id);

            if (actuator_value != null)
            {
                actuator_value.execution = value.execution;
                actuator_value.timestamp = value.timestamp;
                actuator_value.id_actuator_associated = value.id_actuator_associated;
                DB.SaveChanges();
            }
        }

        [HttpDelete]
        // PUT api/Delete/ActuatorValue/Id/{id}
        [Route("api/Delete/ActuatorValue/Id/{id}")]
        public void DeleteActuatorValueId(int id)
        {
            var actuator_value = DB.actuator_value.FirstOrDefault(x => x.id_actuator_value == id);

            if (actuator_value != null)
            {
                DB.actuator_value.Remove(actuator_value);
                DB.SaveChanges();
            }
        }
    }
}