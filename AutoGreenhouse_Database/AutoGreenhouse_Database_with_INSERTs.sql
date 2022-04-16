GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[actuator](
	[id_actuator] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](max) NOT NULL,
	[name] [varchar](max) NULL,
	[description] [varchar](max) NULL,
	[id_device_associated] [int] NOT NULL,
 CONSTRAINT [PK_actuator] PRIMARY KEY CLUSTERED 
(
	[id_actuator] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[actuator_value]    Script Date: 21/02/2022 19:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[actuator_value](
	[id_actuator_value] [int] IDENTITY(1,1) NOT NULL,
	[execution] [tinyint] NOT NULL,
	[timestamp] [datetime2](7) NOT NULL,
	[id_actuator_associated] [int] NOT NULL,
 CONSTRAINT [PK_actuator_value] PRIMARY KEY CLUSTERED 
(
	[id_actuator_value] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device]    Script Date: 21/02/2022 19:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device](
	[id_device] [int] IDENTITY(1,1) NOT NULL,
	[ip] [varchar](max) NOT NULL,
	[name] [varchar](max) NULL,
	[time_connect] [datetime2](7) NULL,
	[id_plant_associated] [int] NOT NULL,
 CONSTRAINT [PK_device] PRIMARY KEY CLUSTERED 
(
	[id_device] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[plant]    Script Date: 21/02/2022 19:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[plant](
	[id_plant] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](max) NOT NULL,
	[description] [varchar](max) NULL,
	[air_temperature] [float] NOT NULL,
	[air_humidity] [float] NOT NULL,
	[ground_humidity] [float] NOT NULL,
	[quantity_fertilizer_week] [float] NULL,
 CONSTRAINT [PK_plant] PRIMARY KEY CLUSTERED 
(
	[id_plant] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sensor]    Script Date: 21/02/2022 19:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sensor](
	[id_sensor] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](max) NOT NULL,
	[name] [varchar](max) NULL,
	[description] [varchar](max) NULL,
	[id_device_associated] [int] NOT NULL,
 CONSTRAINT [PK_sensor] PRIMARY KEY CLUSTERED 
(
	[id_sensor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sensor_value]    Script Date: 21/02/2022 19:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sensor_value](
	[id_sensor_value] [int] IDENTITY(1,1) NOT NULL,
	[value] [float] NOT NULL,
	[timestamp] [datetime2](7) NOT NULL,
	[id_sensor_associated] [int] NOT NULL,
 CONSTRAINT [PK_sensor_value] PRIMARY KEY CLUSTERED 
(
	[id_sensor_value] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[actuator]  WITH CHECK ADD  CONSTRAINT [FK_actuator_device] FOREIGN KEY([id_device_associated])
REFERENCES [dbo].[device] ([id_device])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[actuator] CHECK CONSTRAINT [FK_actuator_device]
GO
ALTER TABLE [dbo].[actuator_value]  WITH CHECK ADD  CONSTRAINT [FK_actuator_value_actuator] FOREIGN KEY([id_actuator_associated])
REFERENCES [dbo].[actuator] ([id_actuator])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[actuator_value] CHECK CONSTRAINT [FK_actuator_value_actuator]
GO
ALTER TABLE [dbo].[device]  WITH CHECK ADD  CONSTRAINT [FK_device_plant] FOREIGN KEY([id_plant_associated])
REFERENCES [dbo].[plant] ([id_plant])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[device] CHECK CONSTRAINT [FK_device_plant]
GO
ALTER TABLE [dbo].[sensor]  WITH CHECK ADD  CONSTRAINT [FK_sensor_device] FOREIGN KEY([id_device_associated])
REFERENCES [dbo].[device] ([id_device])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[sensor] CHECK CONSTRAINT [FK_sensor_device]
GO
ALTER TABLE [dbo].[sensor_value]  WITH CHECK ADD  CONSTRAINT [FK_sensor_value_sensor] FOREIGN KEY([id_sensor_associated])
REFERENCES [dbo].[sensor] ([id_sensor])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[sensor_value] CHECK CONSTRAINT [FK_sensor_value_sensor]
GO
/*INSERTs*/
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
