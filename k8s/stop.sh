#!/bin/bash

path=$(realpath "$0")
dir=$(dirname $path)

k3d cluster delete clugest