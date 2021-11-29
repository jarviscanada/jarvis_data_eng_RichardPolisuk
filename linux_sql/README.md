# Linux Cluster Monitoring Agent
This project is under development. Since this project follows the GitFlow, the final work will be merged to the master branch after Team Code Team.

# Introduction
The purpose of this project is to provide a monitoring
solution to the Jarvis Linux Cluster Administration (LCA) team.
Custom Linux agents will be run on each node of the Linux cluster running
CentOS 7 and will record hardware specifications of
the servers and will collect CPU/memory resource usage
every minute. This information will be added and stored in
a central Postgres database. Reports will be generated
against this data by the LCA team to help monitor the cluster.

The technologies used to develop this tool are:
- bash scripts (used to gather the hardware specifications, 
resource usage, and manage docker)
- Postgres v9.6 database (stores the collected data)
- psql v9.2 (used to administer the Postgres database)
- git v2.30.1 (version control software)
- Docker v20.10.11 (container running the PostGre database)
- IntelliJ IDEA v2021.2.3 (used as the IDE to edit files)
- Jarvis Remote Desktop (JRD) (running on CentOS 7)
- Google Cloud Platform provided the instance to run the JRD

# Quick Start
The following are the quick start commands/files needed to manage ths system.

## psql_docker.sh
This command is used to create a new psql container and
to stop/start the containers.

```
./scripts/psql_docker.sh start|stop|create [db_username] [db_password]
```

### Options:
#### start
This command will start the docker container.
#### stop
This command will stop the docker container.
#### create 
This command requires two addition arguments for the Postgres 
username and password to create the database. This command will
provision a new container and install the required Postgres image
on it. The default listening port is TCP/5432 is used.

## ddl.sql
This file contains the Postgres schema required to create the two tables
to store the hardware and CPU/memory information. It should be called
using the psql command.
````
    psql -h localhost -U postgres -d host_agent -f sql/ddl.sql    
````

## host_info.sh

```
    ./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password
```

## host_usage.sh

```
    ./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password
```

## Crontab setup

```
    # edit crontab file
    crontab -e

    # add following line to the file
    * * * * * bash <your path>/host_usage.sh psql_host psql_port db_name psql_user psql_password > /tmp/host_usage.log
```


# Implementation

## Architecture
![Architecture diagram](./assets/architecture.jpg)

## Scripts

## Database Modeling

# Test

# Deployment

# Improvements
