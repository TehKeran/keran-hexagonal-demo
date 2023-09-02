CREATE TABLE IF NOT EXISTS def_loyalty_card_type (
    id                          UUID PRIMARY KEY not null,
    value                       varchar(255) not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS def_loyalty_account_type (
    id                          UUID PRIMARY KEY not null,
    value                       varchar(255) not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_customer (
    id                          UUID PRIMARY KEY not null,
    customer_number             varchar(255) not null,
    registration_date           timestamp not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_account (
    id                          UUID PRIMARY KEY not null,
    loyalty_customer_id         UUID not null,
    loyalty_program_id          UUID not null,
    loyalty_account_type_id     UUID not null,
    account_number              varchar(255) unique not null,
    external_account_number     varchar(255),
    start_date                  timestamp not null,
    close_date                  timestamp,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_account_transaction_history (
    id                          UUID PRIMARY KEY not null,
    loyalty_account_id          UUID not null,
    date_of_transaction         timestamp not null,
    previous_balance            int unique not null,
    amount                      int not null,
    new_balance                 int not null,
    comment                     varchar(255),
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_card (
    id                          UUID PRIMARY KEY not null,
    loyalty_customer_id         UUID not null,
    loyalty_card_type_id        UUID not null,
    card_number                 varchar(55) unique not null,
    display_name                varchar(255) not null,
    card_image_url              varchar(255) not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_event (
    id                          UUID PRIMARY KEY not null,
    name                        varchar(255) not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_event_configuration (
    id                          UUID PRIMARY KEY not null,
    loyalty_program_id          UUID not null,
    loyalty_event_id            UUID not null,
    loyalty_points_to_award     int not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_event_occurrence (
    id                          UUID PRIMARY KEY not null,
    loyalty_customer_id         UUID not null,
    loyalty_event_id            UUID not null,
    date_of_occurrence          timestamp not null,
    quantity_of_occurrence      int not null,
    source                      varchar(255) not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_program (
    id                          UUID PRIMARY KEY not null,
    name                        varchar(255) not null,
    description                 varchar(255) not null,
    start_date                  timestamp not null,
    end_date                    timestamp not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_point (
    id                          UUID PRIMARY KEY not null,
    name                        varchar(255) unique not null,
    image_url                   varchar(255) not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS loyalty_point_balance (
    id                          UUID PRIMARY KEY not null,
    loyalty_account_id          UUID not null,
    loyalty_point_id            UUID not null,
    balance                     int not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS person (
    id                          UUID PRIMARY KEY not null,
    loyalty_customer_id         UUID not null,
    salutation                  varchar(255) not null,
    first_name                  varchar(255) not null,
    middle_name                 varchar(255),
    first_last_name             varchar(255) not null,
    second_last_name            varchar(255),
    date_of_birth               timestamp not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS consent (
    id                          UUID PRIMARY KEY not null,
    loyalty_customer_id         UUID not null,
    consent_name                varchar(255) not null,
    is_granted                  boolean not null,
    date_of_granting            timestamp,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS contact_email (
    id                          UUID PRIMARY KEY not null,
    person_id                   UUID not null,
    email_address		        varchar(20) not null unique,
    is_primary_contact_email    boolean not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS contact_telephone (
    id                          UUID PRIMARY KEY not null,
    person_id                   UUID not null,
    country_code                varchar(20) not null,
    telephone_number            varchar(20) not null,
    is_primary_telephone_number boolean not null,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

CREATE TABLE IF NOT EXISTS address (
    id                          UUID PRIMARY KEY not null,
    person_id                   UUID not null,
    country_code_iso_3_code     varchar(3) not null,
    region                      varchar(255),
    province                    varchar(255),
    city                        varchar(255) not null,
    zip_code                    varchar(255) not null,
    street_name                 varchar(255) not null,
    building_number             int not null,
    apartment_number            int,
    last_modification_by        varchar(255),
    last_modification_on        timestamp
);

---- Joins
-- Loyalty account:
ALTER TABLE IF EXISTS loyalty_account
    ADD CONSTRAINT fk_loyalty_account_to_loyalty_customer FOREIGN KEY (loyalty_customer_id)
    REFERENCES loyalty_customer (id);
ALTER TABLE IF EXISTS loyalty_account
    ADD CONSTRAINT fk_loyalty_account_to_loyalty_program FOREIGN KEY (loyalty_program_id)
        REFERENCES loyalty_program (id);
ALTER TABLE IF EXISTS loyalty_account
    ADD CONSTRAINT fk_loyalty_account_to_def_loyalty_account_type FOREIGN KEY (loyalty_account_type_id)
        REFERENCES def_loyalty_account_type (id);

-- Loyalty account transaction history
ALTER TABLE IF EXISTS loyalty_account_transaction_history
    ADD CONSTRAINT fk_loyalty_account_transaction_history_to_loyalty_account FOREIGN KEY (loyalty_account_id)
        REFERENCES loyalty_account (id);

-- Loyalty card
ALTER TABLE IF EXISTS loyalty_card
    ADD CONSTRAINT fk_loyalty_card_to_loyalty_customer FOREIGN KEY (loyalty_customer_id)
        REFERENCES loyalty_customer (id);
ALTER TABLE IF EXISTS loyalty_card
    ADD CONSTRAINT fk_loyalty_card_to_def_loyalty_cardy_type FOREIGN KEY (loyalty_card_type_id)
        REFERENCES def_loyalty_card_type (id);

-- Loyalty event configuration
ALTER TABLE IF EXISTS loyalty_event_configuration
    ADD CONSTRAINT fk_loyalty_event_configuration_to_loyalty_event FOREIGN KEY (loyalty_event_id)
        REFERENCES loyalty_event (id);
ALTER TABLE IF EXISTS loyalty_event_configuration
    ADD CONSTRAINT fk_loyalty_event_configuration_to_loyalty_program FOREIGN KEY (loyalty_program_id)
        REFERENCES loyalty_program (id);

-- Loyalty event occurrence
ALTER TABLE IF EXISTS loyalty_event_occurrence
    ADD CONSTRAINT fk_loyalty_event_occurrence_to_loyalty_event FOREIGN KEY (loyalty_event_id)
        REFERENCES loyalty_event (id);
ALTER TABLE IF EXISTS loyalty_event_occurrence
    ADD CONSTRAINT fk_loyalty_event_occurrence_to_loyalty_customer FOREIGN KEY (loyalty_customer_id)
        REFERENCES loyalty_customer (id);

-- Loyalty point balance
ALTER TABLE IF EXISTS loyalty_point_balance
    ADD CONSTRAINT fk_loyalty_point_balance_to_loyalty_point FOREIGN KEY (loyalty_point_id)
        REFERENCES loyalty_point (id);
ALTER TABLE IF EXISTS loyalty_point_balance
    ADD CONSTRAINT fk_loyalty_point_balance_to_loyalty_account FOREIGN KEY (loyalty_account_id)
        REFERENCES loyalty_account (id);

-- Person
ALTER TABLE IF EXISTS person
    ADD CONSTRAINT fk_person_to_loyalty_customer FOREIGN KEY (loyalty_customer_id)
        REFERENCES loyalty_customer (id);

-- Consent
ALTER TABLE IF EXISTS consent
    ADD CONSTRAINT fk_consent_to_loyalty_customer FOREIGN KEY (loyalty_customer_id)
        REFERENCES loyalty_customer (id);

-- contact_email
ALTER TABLE IF EXISTS contact_email
    ADD CONSTRAINT fk_contact_email_to_person FOREIGN KEY (person_id)
        REFERENCES person (id);

-- contact_telephone
ALTER TABLE IF EXISTS contact_telephone
    ADD CONSTRAINT fk_contact_telephone_to_person FOREIGN KEY (person_id)
        REFERENCES person (id);

-- address
ALTER TABLE IF EXISTS address
    ADD CONSTRAINT fk_address_to_person FOREIGN KEY (person_id)
        REFERENCES person (id);

---- Indices
-- loyalty program
CREATE UNIQUE INDEX loyalty_account_account_number_index
    on public.loyalty_account (account_number);

-- Loyalty account
CREATE INDEX loyalty_account_loyalty_program_id_index
    on public.loyalty_account (loyalty_program_id);

-- loyalty card
CREATE UNIQUE INDEX loyalty_card_card_number_index
    on public.loyalty_card (card_number);

-- loyalty point balance
CREATE INDEX loyalty_point_balance_loyalty_account_id_index
    on public.loyalty_point_balance (loyalty_account_id);

-- loyalty customer
CREATE UNIQUE INDEX loyalty_customer_customer_number_index
    on public.loyalty_customer (customer_number);

-- loyalty program
CREATE UNIQUE INDEX loyalty_program_name_index
    on public.loyalty_program (name);

-- loyalty event
CREATE UNIQUE INDEX loyalty_event_name_index
    on public.loyalty_event (name);

-- person
CREATE INDEX person_first_name_index
    on public.person (first_name);
CREATE INDEX person_middle_name_index
    on public.person (middle_name);
CREATE INDEX person_first_last_name_index
    on public.person (first_last_name);
CREATE INDEX person_second_last_name_index
    on public.person (second_last_name);

-- address
CREATE INDEX address_country_code_iso_3_code_index
    on public.address (country_code_iso_3_code);
CREATE INDEX address_city_index
    on public.address (city);
CREATE INDEX address_zip_code_index
    on public.address (zip_code);

-- contact telephone
CREATE INDEX contact_telephone_telephone_number_index
    on public.contact_telephone (telephone_number);

-- contact email
CREATE INDEX contact_email_email_index
    on public.contact_email (email_address);