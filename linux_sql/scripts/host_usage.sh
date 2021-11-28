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
df_out=$(df -BM /)
hostname=$(hostname -f)

memory_free=$(echo "$(vmstat --unit M)" | awk '{print $4 }' | sed -n 3p)
cpu_idle=$(echo "$(vmstat)" | awk 'NR==3 {print $15 }' | xargs)
cpu_kernel=$(echo "$(vmstat -t)" | awk '{print $14}' | sed -n 3p)
disk_io=$(echo "$(vmstat -d)" | awk '{print 10}' | sed -n 3p)
disk_available=$(echo "$df_out" | awk '{print $4}' | sed -n 2p | sed 's/.$//')

statement="INSERT INTO host_usage
          (host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
          VALUES
          ((SELECT id FROM host_info WHERE hostname='$hostname'), $memory_free, $cpu_idle, $cpu_kernel, $disk_io, $disk_available)"

export PGPASSWORD=psql_password
echo psql -h "$host" -p "$port" -U "$username" -d "$db_name" -c "$statement"
exit $?