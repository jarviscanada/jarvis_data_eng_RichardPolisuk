\c host_agent;

CREATE TABLE IF NOT EXISTS PUBLIC.host_info
(
    id               SERIAL   PRIMARY KEY,
    hostname         VARCHAR  UNIQUE NOT NULL,
    cpu_number       SMALLINT NOT NULL,
    cpu_architecture VARCHAR  NOT NULL,
    cpu_model        VARCHAR  NOT NULL,
    cpu_mhz          REAL     NOT NULL,
    L2_cache         INTEGER  NOT NULL,
    total_mem        REAL     NOT NULL,
    timestamp        TIMESTAMP DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS PUBLIC.host_usage
(
    timestamp      TIMESTAMP DEFAULT NOW(),
    host_id        INTEGER PRIMARY KEY REFERENCES PUBLIC.host_info (id),
    memory_free    INTEGER NOT NULL,
    cpu_idle       INTEGER NOT NULL,
    cpu_kernel     INTEGER NOT NULL,
    disk_io        INTEGER NOT NULL,
    disk_available INTEGER NOT NULL
);