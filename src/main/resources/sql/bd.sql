CREATE TYPE request_status AS ENUM ('PENDING', 'APPROVED', 'REJECTED');
CREATE TYPE order_status AS ENUM ('NEW', 'PAID', 'CLOSED');
CREATE TYPE car_status AS ENUM ('AVAILABLE', 'RENTED', 'BROKEN');

CREATE TABLE client (
    id_client BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(50),
    passport_number VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE admin (
   id_admin BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   username VARCHAR(100) UNIQUE NOT NULL,
   password VARCHAR(255) NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE car (
     id_car BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
     brand VARCHAR(100) NOT NULL,
     model VARCHAR(100) NOT NULL,
     production_year INT NOT NULL,
     price_per_day NUMERIC(10,2) NOT NULL,
     car_number VARCHAR(50),
     status car_status DEFAULT 'AVAILABLE'
);

CREATE TABLE rental_request (
    id_rental_request BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_client BIGINT NOT NULL REFERENCES client(id) ON DELETE CASCADE,
    id_car BIGINT NOT NULL REFERENCES car(id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status request_status DEFAULT 'PENDING',
    rejection_reason TEXT,
    processed_by BIGINT REFERENCES admin(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE rental_order (
    id_order BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_rental_request BIGINT UNIQUE NOT NULL REFERENCES rental_request(id_rental_request),
    id_client BIGINT NOT NULL REFERENCES client(id),
    id_car BIGINT NOT NULL REFERENCES car(id),
    total_amount NUMERIC(12,2) NOT NULL,
    status order_status DEFAULT 'NEW',
    payment_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE payment (
     id_payment BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
     id_order BIGINT NOT NULL REFERENCES rental_order(id_order) ON DELETE CASCADE,
     amount NUMERIC(12,2) NOT NULL,
     payment_method VARCHAR(50),
     payment_status VARCHAR(50) DEFAULT 'SUCCESS',
     payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);