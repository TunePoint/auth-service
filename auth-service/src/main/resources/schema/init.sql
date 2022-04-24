CREATE SCHEMA auth;

CREATE TABLE auth.users
(
    id            SERIAL PRIMARY KEY,
    username      VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255)        NOT NULL,
    email         VARCHAR(255) UNIQUE NOT NULL,
    is_confirmed   BOOLEAN DEFAULT FALSE,
    is_enabled    BOOLEAN DEFAULT TRUE,
    created_at    TIMESTAMP,
    updated_at    TIMESTAMP
);

CREATE TABLE auth.roles
(
    id   INTEGER PRIMARY KEY,
    name VARCHAR(64)
);

CREATE TABLE auth.users_roles
(
    user_id INTEGER REFERENCES auth.users (id) ON DELETE CASCADE,
    role_id INTEGER REFERENCES auth.roles (id),

    CONSTRAINT users_roles_fk PRIMARY KEY (user_id, role_id)
);

CREATE TABLE auth.confirmation_codes
(
    id       INTEGER REFERENCES auth.users (id) ON DELETE CASCADE NOT NULL,
    code     VARCHAR(32)                                             NOT NULL,
    due_date TIMESTAMP,
    last_sent TIMESTAMP,
    attempts INTEGER DEFAULT 0
);

CREATE INDEX users_id_idx ON auth.users (id);
CREATE INDEX verification_codes_id_idx ON auth.confirmation_codes (id);