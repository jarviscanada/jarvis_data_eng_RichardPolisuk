-- you can also create a function for convenience purposes so your qeury looks cleaner
CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
$$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;

-- Query 1
SELECT
    cpu_number || ',' || id || ',' || TRIM( BOTH FROM to_char(total_mem / 1024, '99999999'))
FROM
    PUBLIC.host_info
ORDER BY
    cpu_number,
    total_mem DESC;

-- Query 2
SELECT
	hu.host_id || ',' ||
	hi.hostname || ',' ||
	round5(hu.timestamp) || ',' ||
	AVG((((hi.total_mem::float)/1000 - hu.memory_free::float) / (hi.total_mem::float/1000)) * 100):: int
FROM
     host_usage hu
     INNER JOIN host_info hi ON hu.host_id = hi.id
GROUP BY
    round5(hu.timestamp),
    hu.host_id,
    hi.hostname,
    hi.total_mem
ORDER BY
    hu.host_id,
    round5(hu.timestamp);

-- Query 3
SELECT
    host_id,
    round5(timestamp) AS ts,
    COUNT(*) AS num_data_points
FROM
    host_usage
GROUP BY
    host_id,
    round5(timestamp)
HAVING
    COUNT(*) < 3
ORDER BY
    host_id;
