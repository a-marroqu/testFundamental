CREATE TABLE patients (
    patient_id       SERIAL         NOT NULL,
    patient_name     VARCHAR(255)   NOT NULL,
    patient_surname  VARCHAR(255)   NOT NULL,
    patient_sickness VARCHAR(255)   NOT NULL,
    PRIMARY KEY (patient_id)
)