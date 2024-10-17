#!/bin/bash

## add the following lines to /etc/hosts
# 127.10.1.1 k8s.clugest.home
# 127.10.1.2 clugest.home mariadb.clugest.home
# 127.10.1.3 dashboard.clugest.home

path=$(realpath "$0")
dir=$(dirname $path)

## k3d cluster
k3d cluster create --config cluster.yml
