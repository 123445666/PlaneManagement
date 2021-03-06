USE [PlaneManagement]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 08/04/2014 19:15:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[identityNo] [nchar](12) NOT NULL,
	[birthday] [date] NULL,
	[phone] [nchar](15) NULL,
	[email] [nchar](50) NOT NULL,
	[status] [tinyint] NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Customer] ON
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (1, N'Phạm Đăng Bắc', N'172642017   ', CAST(0xD4130B00 AS Date), N'0918398969     ', N'bac@gmail.com                                     ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (2, N'Vũ Bằng Biệt', N'172642019   ', CAST(0xAF150B00 AS Date), N'0916038120     ', N'viet@gmail.com                                    ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (3, N'Nguyễn Tiến Toản', N'172642020   ', CAST(0x7D1B0B00 AS Date), N'0916038121     ', N'toan@gmail,com                                    ', 0)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (5, N'Nguyễn Đức Thành', N'172642025   ', CAST(0x2F150B00 AS Date), N'09160381205    ', N'thanh@gmail,com                                   ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (6, N'Nguyễn Đức Khánh', N'1726042026  ', CAST(0x2D150B00 AS Date), N'0916038126     ', N'khanh@gmail.com                                   ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (7, N'Nguyễn Đình Tiệp', N'172642020   ', CAST(0x4F1C0B00 AS Date), N'0916038121     ', N'tiep@gmail.com                                    ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (8, N'Nguyễn Thanh Bản', N'172642027   ', CAST(0x4C150B00 AS Date), N'0916038127     ', N'ban@gmail.com                                     ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (9, N'Nguyễn Văn Định', N'172642028   ', CAST(0xA7150B00 AS Date), N'0916038128     ', N'dinh@gmail.com                                    ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (10, N'Đinh Thị Ngọc', N'172642029   ', CAST(0xC4130B00 AS Date), N'0916038129     ', N'ngoc@gmail.com                                    ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (11, N'Đỗ Thị Thuận', N'1726042030  ', CAST(0xC3090B00 AS Date), N'091603830      ', N'thuan@gmail.com                                   ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (12, N'Đào Thị Hương', N'172642031   ', CAST(0x9D0C0B00 AS Date), N'0916038130     ', N'huong@gmail.com                                   ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (14, N'Lê Thị Thùy', N'172642033   ', CAST(0xE0130B00 AS Date), N'0916038133     ', N'thuy@gmail.com                                    ', 0)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (15, N'Lê Thị Thúy', N'172642035   ', CAST(0x2D150B00 AS Date), N'0916038134     ', N'thuy1@gmail.com                                   ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (25, N'Nguyễn Xuân Phông', N'1           ', CAST(0xD8380B00 AS Date), N'1              ', N'1                                                 ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (26, N'Nguyễn Xuân Phông', N'1           ', CAST(0xD8380B00 AS Date), N'1              ', N'1                                                 ', 1)
INSERT [dbo].[Customer] ([ID], [name], [identityNo], [birthday], [phone], [email], [status]) VALUES (27, N'Đỗ Trọng Bằng', N'2           ', CAST(0xD8380B00 AS Date), N'2              ', N'2                                                 ', 1)
SET IDENTITY_INSERT [dbo].[Customer] OFF
/****** Object:  Table [dbo].[Route]    Script Date: 08/04/2014 19:15:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Route](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[fromplace] [nvarchar](50) NOT NULL,
	[toplace] [nvarchar](50) NOT NULL,
	[distance] [float] NOT NULL,
	[description] [nvarchar](100) NULL,
	[status] [tinyint] NOT NULL,
 CONSTRAINT [PK_Route] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plane]    Script Date: 08/04/2014 19:15:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plane](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[lenght] [float] NOT NULL,
	[weight] [float] NOT NULL,
	[color] [nvarchar](50) NOT NULL,
	[seats] [int] NOT NULL,
	[description] [nvarchar](100) NULL,
	[status] [tinyint] NOT NULL,
 CONSTRAINT [PK_Plane] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 08/04/2014 19:15:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[ID_Customer] [int] NOT NULL,
	[status] [tinyint] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'bac1', N'1', 1, 1)
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'bac10', N'12', 1, 1)
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'bac2', N'1', 2, 0)
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'bac9', N'1', 2, 1)
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'hehe', N'123', 1, 0)
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'thanh', N'123', 5, 1)
INSERT [dbo].[Users] ([username], [password], [ID_Customer], [status]) VALUES (N'viet', N'1', 2, 1)
/****** Object:  Table [dbo].[Flight]    Script Date: 08/04/2014 19:15:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Flight](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_Route] [int] NOT NULL,
	[ID_Plane] [int] NOT NULL,
	[starttime] [datetime] NOT NULL,
	[endtime] [datetime] NOT NULL,
	[status] [tinyint] NOT NULL,
 CONSTRAINT [PK_Flight] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 08/04/2014 19:15:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_Customer] [int] NOT NULL,
	[ID_Flight] [int] NOT NULL,
	[payment] [money] NOT NULL,
	[datecreate] [datetime] NOT NULL,
	[description] [nvarchar](100) NULL,
	[status] [tinyint] NOT NULL,
 CONSTRAINT [PK_Booking] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_Booking_Customer]    Script Date: 08/04/2014 19:15:58 ******/
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Customer] FOREIGN KEY([ID_Customer])
REFERENCES [dbo].[Customer] ([ID])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Customer]
GO
/****** Object:  ForeignKey [FK_Booking_Flight]    Script Date: 08/04/2014 19:15:58 ******/
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Flight] FOREIGN KEY([ID_Flight])
REFERENCES [dbo].[Flight] ([ID])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Flight]
GO
/****** Object:  ForeignKey [FK_Flight_Plane]    Script Date: 08/04/2014 19:15:58 ******/
ALTER TABLE [dbo].[Flight]  WITH CHECK ADD  CONSTRAINT [FK_Flight_Plane] FOREIGN KEY([ID_Plane])
REFERENCES [dbo].[Plane] ([ID])
GO
ALTER TABLE [dbo].[Flight] CHECK CONSTRAINT [FK_Flight_Plane]
GO
/****** Object:  ForeignKey [FK_Flight_Route]    Script Date: 08/04/2014 19:15:58 ******/
ALTER TABLE [dbo].[Flight]  WITH CHECK ADD  CONSTRAINT [FK_Flight_Route] FOREIGN KEY([ID_Route])
REFERENCES [dbo].[Route] ([ID])
GO
ALTER TABLE [dbo].[Flight] CHECK CONSTRAINT [FK_Flight_Route]
GO
/****** Object:  ForeignKey [FK_Users_Customer]    Script Date: 08/04/2014 19:15:58 ******/
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Customer] FOREIGN KEY([ID_Customer])
REFERENCES [dbo].[Customer] ([ID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Customer]
GO
