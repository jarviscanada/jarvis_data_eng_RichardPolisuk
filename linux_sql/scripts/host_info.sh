#! /bin/bash

# Store the command lime arguments
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

# Check the correct number of arguments have been passed
if [ $# -ne 5 ];
then
    echo "Invalid number of arguments"
    echo "Usage: host port db_name username password"
    exit 1
fi

lscpu_out=$(lscpu)

# Get hardware information
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out" | grep '^CPU(s)' | cut -f 2 -d ":" | awk '{$1=$1}1')
cpu_architecture=$(echo "$lscpu_out" | grep '^Architecture' | cut -f 2 -d ":" | awk '{$1=$1}1')
cpu_model=$(echo "$lscpu_out" | grep '^Model name' | cut -f 2 -d ":" | awk '{$1=$1}1')
cpu_mhz=$(echo "$lscpu_out" | grep '^CPU MHz' | cut -f 2 -d ":" | awk '{$1=$1}1')
l2_cache=$(echo "$lscpu_out" | grep '^L2 cache' | cut -f 2 -d ":" | awk '{$1=$1}1' | cut -f 1 -d "K")
total_mem=$(free | awk 'NR==2 {print $2 }' | xargs)

statement="INSERT INTO PUBLIC.host_info
          (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem)
          VALUES
          ('$hostname', $cpu_number, '$cpu_architecture', '$cpu_model', $cpu_mhz, $l2_cache, $total_mem)"

export PGPASSWORD=$psql_password
psql -h "$psql_host" -p "$psql_port" -U "$psql_user" -d "$db_name" -c "$statement"
exit $?