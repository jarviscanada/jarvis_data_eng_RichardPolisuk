#! /bin/bash

# Store the command lime arguments
cmd=$1
db_username=$2
db_password=$3

# Check if docker is started and if not start it.
sudo systemctl status docker &>/dev/null || sudo systemctl start docker
retVal=$?
if [ $retVal -ne 0 ]; then
  echo "Error starting Docker. Exiting..."
  exit $retVal
fi

# Check the Postgres container status
docker container inspect jrvs-psql &>/dev/null
container_status=$?

# Process the arguments
case $cmd in
create)

  # Ensure there are three arguemnts
  if [ $# -ne 3 ]; then
    echo 'create option requires additional username and password'
    exit 1
  fi

  # Make sure container is created, otherwise exit
  if [ $container_status -eq 0 ]; then
    echo 'Container already exists'
    exit 1
  fi

  #Get the image
  docker pull postgres:9-alpine &>/dev/null
  retVal=$?
  if [ $retVal -ne 0 ]; then
    echo "Error pulling Postgres image from DockerHub. Exiting..."
    exit $retVal
  fi

  # Create the docker volume, exit if failed
  docker volume create pgdata &>/dev/null
  retVal=$?
  if [ $retVal -ne 0 ]; then
    echo "Error pulling creating docker volume. Exiting..."
    exit $retVal
  fi

  # Run the docker container, exit if failed
  docker run \
    --name jrvs-psql \
    --env POSTGRES_PASSWORD="${db_password}" \
    --env POSTGRES_USER="${db_username}" \
    --detach \
    --volume pgdata:/var/lib/postgresql/data \
    --publish 5432:5432 \
    postgres:9-alpine
  retVal=$?
  if [ $retVal -ne 0 ]; then
    echo "Error pulling running docker container. Exiting..."
    exit $retVal
  fi
  exit $?
  ;;

start | stop)

  # Make sure correct number of parameters
  if [ $# -ne 1 ]; then
    echo 'No additional parameters are required. Exiting...'
    exit 1
  fi

  # Make sure container exists, otherwise exit
  if [ $container_status -ne 0 ]; then
    echo 'Container already exists'
    exit 1
  fi

  # Start or stop the container
  docker container "$cmd" jrvs-psql
  exit $?
  ;;

*)
  echo 'Illegal command'
  echo 'Commands: start|stop|create'
  exit 1
  ;;
esac
