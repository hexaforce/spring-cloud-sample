#!/bin/bash -ex

su elasticsearch /elasticsearch/bin/elasticsearch &

sleep 5

/logstash/bin/logstash -f /etc/conf.d/logstash &

/kibana/bin/kibana
