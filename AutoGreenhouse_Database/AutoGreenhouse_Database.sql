GO
/****** Object:  Table [dbo].[actuator]    Script Date: 21/02/2022 19:27:19 ******/
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
