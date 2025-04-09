CREATE TABLE organizations(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL ,
    contact varchar(11) NOT NULL
);

CREATE TABLE projects(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    description varchar(255),
    region varchar(255) NOT NULL ,
    cO2_Reduction_Estimate numeric,
    organization_id BIGINT NOT NULL,
    CONSTRAINT fk_project_organization FOREIGN KEY (organization_id) REFERENCES organizations(id)
);