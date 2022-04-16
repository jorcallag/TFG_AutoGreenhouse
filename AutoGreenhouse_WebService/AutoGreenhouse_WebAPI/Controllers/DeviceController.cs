using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TFG_WebAPI.Models;

namespace TFG_WebAPI.Controllers
{
    public class DeviceController : ApiController
    {
        autogreenhousedbEntities DB = new autogreenhousedbEntities();

        [HttpGet]
        // GET api/Get/Devices/
        [Route("api/Get/Devices/")]
        public ICollection<device> GetDevices()
        {
            var devices = DB.device.ToList();
            return devices;
        }

        // GET api/Get/Device/Id/{id}
        [Route("api/Get/Device/Id/{id}")]
        public device GetDeviceId(int id)
        {
            var device = DB.device.FirstOrDefault(x => x.id_device == id);
            return device;
        }

        // GET api/Get/Device/Name/{name}
        [Route("api/Get/Device/Name/{name}")]
        public device GetDeviceName(string name)
        {
            var device = DB.device.FirstOrDefault(x => x.name == name);
            return device;
        }

        [HttpPost]
        // POST api/Post/Device/
        [Route("api/Post/Device/")]
        public void PostDevice([FromBody] device value)
        {
            DB.device.Add(value);
            DB.SaveChanges();
        }

        [HttpPut]
        // PUT api/Put/Device/Id/{id}
        [Route("api/Put/Device/Id/{id}")]
        public void PutDeviceId(int id, [FromBody] device value)
        {
            var device = DB.device.FirstOrDefault(x => x.id_device == id);

            if (device != null)
            {
                device.ip = value.ip;
                device.name = value.name;
                device.time_connect = value.time_connect;
                device.id_plant_associated = value.id_plant_associated;
                DB.SaveChanges();
            }
        }

        [HttpDelete]
        // DELETE api/Delete/Device/Id/{id}
        [Route("api/Delete/Device/Id/{id}")]
        public void DeleteDeviceId(int id)
        {
            var device = DB.device.FirstOrDefault(x => x.id_device == id);

            if (device != null)
            {
                DB.device.Remove(device);
                DB.SaveChanges();
            }
        }
    }
}
