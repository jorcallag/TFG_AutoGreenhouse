//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace TFG_WebAPI.Models
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class autogreenhousedbEntities1 : DbContext
    {
        public autogreenhousedbEntities1()
            : base("name=autogreenhousedbEntities1")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<actuator> actuator { get; set; }
        public virtual DbSet<actuator_value> actuator_value { get; set; }
        public virtual DbSet<device> device { get; set; }
        public virtual DbSet<plant> plant { get; set; }
        public virtual DbSet<sensor> sensor { get; set; }
        public virtual DbSet<sensor_value> sensor_value { get; set; }
    }
}
