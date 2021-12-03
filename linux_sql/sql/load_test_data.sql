-- Load test data for host_info
INSERT INTO PUBLIC.host_info (
  hostname,
  cpu_number,
  cpu_architecture,
  cpu_model,
  cpu_mhz,
  l2_cache,
  total_mem)
VALUES
  ('sample-host-1.us-east1-c.c.jarvis-training-332921.internal',
   2,
   'x86_64',
   'Intel(R) Xeon(R) CPU @ 2.20GHz',
   2200.23,
   256,
   7005740
   ),
  ('sample-host-2.us-east1-c.c.jarvis-training-332921.internal',
   1,
   'x86_64',
   'Intel(R) Xeon(R) CPU @ 2.20GHz',
   2200.23,
   256,
   6005740
  ),
  ('sample-host-3.us-east1-c.c.jarvis-training-332921.internal',
   1,
   'x86_64',
   'Intel(R) Xeon(R) CPU @ 2.20GHz',
   2200.23,
   256,
   5005740
  );

-- Load test data for host_usage
INSERT INTO PUBLIC. host_usage (timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
VALUES
('2021-11-29 09:01:00', 2, 4253, 89, 90, 1, 24355),
('2021-11-29 09:02:00', 2, 3633, 89, 90, 1, 24355),
('2021-11-29 09:03:00', 2, 6589, 89, 90, 1, 24355),
('2021-11-29 09:04:00', 2, 5141, 89, 90, 1, 24355),
('2021-11-29 09:05:00', 2, 5141, 89, 90, 1, 24355),
('2021-11-29 09:01:00', 3, 4253, 89, 90, 1, 24355),
('2021-11-29 09:02:00', 3, 3633, 89, 90, 1, 24355),
('2021-11-29 09:03:00', 3, 6589, 89, 90, 1, 24355),
('2021-11-29 09:04:00', 3, 5141, 89, 90, 1, 24355),
('2021-11-29 09:05:00', 3, 5141, 89, 90, 1, 24355),
('2021-11-29 09:01:00', 4, 6589, 89, 90, 1, 24355),
('2021-11-29 09:08:00', 4, 5141, 89, 90, 1, 24355),
('2021-11-29 09:10:00', 4, 5141, 89, 90, 1, 24355)
;