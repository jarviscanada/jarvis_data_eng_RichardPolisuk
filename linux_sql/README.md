# Linux Cluster Monitoring Agent

# Introduction

The Jarvis Linux Cluster Administration (LCA) runs a Linux cluster of Linux servers that are used by Jarvis consultants.
This project provides a monitoring solution for the LCA team to be able to monitor and properly administer these
servers. Custom Linux agents run on each node of the Linux cluster running CentOS 7 and will record hardware
specifications of the servers and will collect CPU/memory resource usage every minute. This information will be added
and stored in a central Postgres database running on a dedicated server. The LCA team will generate reports using this
data which will help monitor and support the cluster.

The technologies used in this project are:

- bash scripts (used to gather the hardware specifications, resource usage, and manage docker)
- Postgres v9.6 database (stores the collected data)
- psql v9.2 (Postgres client program used to administer the Postgres database)
- git v2.30.1 (version control software)
- Docker v20.10.11 (container running the Postgres database)
- IntelliJ IDEA v2021.2.3 (used as the IDE to edit files)
- Jarvis Remote Desktop (JRD) (development and testing environment running CentOS 7)
- Google Cloud Platform (GCP) provided the instance to run the JRD

# Quick Start

The following are the quick start commands/files needed to manage this system.

## psql_docker.sh

The following command will create the Postgres container.

```
psql_docker.sh create psql_username psql_password
```

where psql_username is the Postgres username and psql_password is the Postgres password.

The following command will start the Postgres container.

```
psql_docker.sh start
```

The following command will stop the Postgres container.

```
psql_docker.sh stop
```

## ddl.sql

The following command will create the Postgres schema required for this project.

````
psql -h localhost -U postgres -d host_agent -f ddl.sql    
````

## host_info.sh

The following command will insert the hardware specifications data into the Postgres database (host_agent). Note: This
command should be executed once and before the host_usage script is executed. It will add the required information to
initialize the server for the Postgres database.

```
host_info.sh psql_host psql_port db_name psql_user psql_password
```

where psql_host is the Postgres host running the database, psq_port is the port the Postgres server is listening on,
db_name is the database name (host_agent is the default), psql_user is the Postgres username used when creating the
database, and psql_password is the Postgres password used when creating the database.

## host_usage.sh

The following command will insert the server usage data into the Postgres database. N

```
host_info.sh psql_host psql_port psql_name psql_user psql_password
```

where psql_host is the Postgres host running the database, psq_port is the port the Postgres server is listening on,
psql_name is the database name (host_agent is the default), psql_user is the Postgres username used when creating the
database, and psql_password is the Postgres password used when creating the database.

## Crontab setup

The following steps are used to configure the Linux server's CRON program to execute the script.

```
# edit crontab file
crontab -e

# add following line to the file
* * * * * bash <your path>/host_usage.sh psql_host psql_port db_name psql_user psql_password > /tmp/host_usage.log
```

# Implementation

The following describes how the project was implemented including the architecture, scripts used, and database
modelling.

## Architecture

The following diagram shows the architecture of the project.

![Architecture diagram](./assets/architecture.jpg)

## Scripts

The following shell scripts are used as part of the project.

## psql_docker.sh

### Description

This script is used to create the docker container running the Postgres database if it already doesn't exist. As well
the script is used to start and stop the docker container.

### Usage

```
psql_docker.sh create psql_username psql_password
```

where psql_username is the Postgres username and psql_password is the Postgres password.

The following command will start the Postgres container.

```
psql_docker.sh start
```

The following command will stop the Postgres container.

```
psql_docker.sh stop
```

## host_info.sh

### Description

This script will gather the host hardware information on the Linux server and send them to the Postgres database. This
information includes the hostname, CPU information, and memory information. Note: This command should be executed once
and before the host_usage script is executed. It will add the required information to initialize the server for the
Postgres database.

### Usage

The following command will insert the hardware specifications data into the Postgres database.

```
host_info.sh psql_host psql_port db_name psql_user psql_password
```

where psql_host is the Postgres host running the database, psq_port is the port the Postgres server is listening on,
db_name is the database name (host_agent is the default), psql_user is the Postgres username used when creating the
database, and psql_password is the Postgres password used when creating the database.

## host_usage.sh

### Description

This script runs every minute and gathers the current usage information for the server when it runs. This information
includes memory information, CPU information, and disk usage. Note: the host_info.sh script needs to be run first to
ensure the Postgres database is set up correctly.

### Usage

The following command will insert the server usage data into the Postgres database.

```
host_info.sh psql_host psql_port psql_name psql_user psql_password
```

where psql_host is the Postgres host running the database, psq_port is the port the Postgres server is listening on,
psql_name is the database name (host_agent is the default), psql_user is the Postgres username used when creating the
database, and psql_password is the Postgres password used when creating the database.

## Crontab setup

### Description

The cron process on the Linux server is used to execute the script every minute. It needs to be configured first to call
the script. Once this is completed the script will execute every minute. This can be confirmed by examining the database
to ensure it is receiving the required information.

### Usage

The following steps are used to configure the Linux server's CRON program to execute the script.

```
# edit crontab file
crontab -e

# add following line to the file
* * * * * bash <your path>/host_usage.sh psql_host psql_port db_name psql_user psql_password > /tmp/host_usage.log
```

## queries.sql

### Usage

This SQL script shows three sample SQL queries that can be run against the monitoring data. The first query shows all
the servers with their number of CPUs and total memory. This is a quick way of seeing the inventory of the servers. The
second query, shows the average memory used over 5-minutes. This is very helpful in seeing if the servers have the
correct amount of memory or if more memory is required. The final query can be used to show if a server is no longer
sending data to the monitoring server.

````
psql -h localhost -U postgres -d host_agent -f queries.sql    
````

## Database Modeling

The Postgres database (host_agent) contains two tables that are used to store the monitoring data:

### host_info

This table stores the host hardware information per Linux server. A unique serial number is created when the information
is loaded which is then used to add the Linux server usage information to the database. This table contains information
about the CPU (number, architecture, model, speed, cache) as well as the total amount of memory in the system.

Column | Type | Description
--------------|------|--------------
id | `SERIAL` | This unique identifier is automatically generate when inserted into the database. This column is the primary key.
hostname | `VARCHAR` | Contains the name of the Linux server
cpu_number | `SMALLINT` | Contains the number of CPUs in the server
cpu_architecture | `VARCHAR` | Contains the architecture of the CPU in the server.
cpu_model | `VARCHAR` | Contains the model of the CPU in the server.
cpu_mhz | `REAL` | Contains the clock speed of the CPU in the server.
L2_cache | `INTEGER` | Contains the size of the L2 cache in the CPU in the server.
total_mem | `REAL` | Contains the total memory installed in the server.
timestamp | `TIMESTAMP` | Timestamp of when data is added to the database. Default is the current timestamp of the server.

### host_usage

This table stores the host usage information. The host id is used to determine which server it came from. The table
contains information about the memory free in the system, the CPU used information, disk IO, and disk available.

Column | Type | Description
--------------|------|--------------
timestamp | `TIMESTAMP` | Timestamp of when data is added to the database. Default is the current timestamp of the server.
host_id | `INTEGER` | Contains the id of the host where the usage data was gathered from. This is a foreign key of the id from the host_info table.
memory_free | `INTEGER` | Contains the amount of memory free.
cpu_idle | `INTEGER` | Contains the percentage of the CPU that is idle (i.e. not being used).
cpu_kernel | ` INTEGER ` | Contains the percentage of CPU usage for the kernel that is being used.
disk_io | `INTEGER` | Contains the amount of disk I/O currently being used.
disk_available | `INTEGER` | Contains the available disk space of the root directory for the server.

# Test

The bash scripts were developed and tested on a Jarvis Remote Desktop instance running on a Google Cloud platform
instance running Centos 7. This single server was able to be used to develop and test the entire solution. It contained
a running docker container with Postgres. The scripts were able to send their information to this database and the SQL
queries were able created using this data. When some data was missing (for more than one server), test data was manually
entered into the database.

# Deployment

All scripts were deployed from the Jarvis Remote Desktop to a GitHub repository. The JRD crontab was used to test an
Linux server. The Postgres docker was created and used as the database.

# Improvements

Some improvements for this project include:

- The current scripts do not perform any error checking if the data is not able to be added to the database. This can be
  if there is an error or if the database is down for any reason. A solution will need to be designed to store the
  information locally when the database is not able to receive the script information and later add it to the database.

- The current host_info script does not allow the host information to be updated if any change occurs such as hardware
  changes or virtual machine changes. The script needs to be updated to replace the existing information with the new
  information.

- The current solution stores the information forever. There needs to be a mechanism to archive and delete older
  information from the database.
