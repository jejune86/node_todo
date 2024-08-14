CREATE Table if not exists pages (
    id int AUTO_INCREMENT Primary KEY,
    title varchar(50)Not Null,
    content varchar(100) not null
);

CREATE Table if not exists login (
    id varchar(20) Primary KEY,
    password varchar(20) not null
);