using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TFG_WebAPI.Models;

namespace TFG_WebAPI.Controllers
{
    public class PlantController : ApiController
    {
        autogreenhousedbEntities DB = new autogreenhousedbEntities();

        [HttpGet]
        [Route("api/Get/Plant/Id/{id}")]
        public plant GetPlanId(int id)
        {
            var plant = DB.plant.FirstOrDefault(x => x.id_plant == id);
            return plant;
        }

        [HttpPost]
        // POST api/Post/Plant/
        [Route("api/Post/Plant/")]
        public void PostPlant([FromBody] plant value)
        {
            DB.plant.Add(value);
            DB.SaveChanges();
        }

        [HttpPut]
        // PUT api/Put/Plant/Id/{id}
        [Route("api/Put/Plant/Id/{id}")]
        public void PutPlantId(int id, [FromBody] plant value)
        {
            var plant = DB.plant.FirstOrDefault(x => x.id_plant == id);

            if (plant != null)
            {
                plant.name = value.name;
                plant.description = value.description;
                plant.air_temperature = value.air_temperature;
                plant.air_humidity = value.air_humidity;
                plant.ground_humidity = value.ground_humidity;
                plant.quantity_fertilizer_week = value.quantity_fertilizer_week;
                DB.SaveChanges();
            }
        }

        [HttpDelete]
        // DELETE api/Delete/Plant/Id/{id}
        [Route("api/Delete/Plant/Id/{id}")]
        public void DeletePlantId(int id)
        {
            var plant = DB.plant.FirstOrDefault(x => x.id_plant == id);

            if(plant != null)
            {
                DB.plant.Remove(plant);
                DB.SaveChanges();
            }
        }
    }
}
