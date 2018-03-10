create table ser_cen(id int not null auto_increment, name_of_outlet varchar(500),name_of_service_provider varchar(500),owns_a_smartphone varchar(10),phone_number bigint,alternate_phone_number bigint,location varchar(300),opening_time time,closing_time time,outlet_established_in varchar(5), primary key(id));

create table type_ser1(id int not null, types_of_vehicles_serviced varchar(500), primary key(id, types_of_vehicles_serviced), foreign key(id) references ser_cen(id) on delete cascade on update cascade);

create table make_ser1(id int not null , make_of_vehicles_serviced varchar(500), primary key(id, make_of_vehicles_serviced), foreign key(id) references ser_cen(id) on delete cascade on update cascade);

create table make_ser2(id int not null, make_of_vehicles_serviced varchar(500), type_of_service varchar(500), primary key(id, make_of_vehicles_serviced, type_of_service), foreign key(id, make_of_vehicles_serviced) references make_ser1(id, make_of_vehicles_serviced) on delete cascade on update cascade);

create table ser_avail(id int not null, services_available  varchar(500), primary key(id, services_available), foreign key(id) references ser_cen(id) on delete cascade on update cascade);





