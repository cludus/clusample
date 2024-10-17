#!/bin/bash

path=$(realpath "$0")
dir=$(dirname $path)

## k3d cluster
k3d cluster create --config cluster.yml

## cert-manager
kubectl apply -f https://github.com/cert-manager/cert-manager/releases/download/v1.15.3/cert-manager.yaml

## dashboard
# helm repo add kubernetes-dashboard https://kubernetes.github.io/dashboard/
helm upgrade -f dashboard/values.yml --install kubernetes-dashboard kubernetes-dashboard/kubernetes-dashboard --create-namespace --namespace kubernetes-dashboard
kubectl apply -f dashboard/admin.sec.yml
# kubectl -n kubernetes-dashboard create token dashboard-admin
# kubectl -n kubernetes-dashboard port-forward svc/kubernetes-dashboard-kong-proxy 8443:443

## mariadb
## see https://github.com/mariadb-operator/mariadb-operator
# helm repo add mariadb-operator https://helm.mariadb.com/mariadb-operator
# helm repo update
helm install mariadb-operator mariadb-operator/mariadb-operator --namespace mariadb-operator --create-namespace
helm install mariadb-operator-crds mariadb-operator/mariadb-operator-crds
kubectl create secret generic mariadb-galera-root-password --from-literal=password=hn978ng9g9n43c34
kubectl apply -f mariadb/mariadb-galera.yml
# kubectl port-forward svc/clugest-mariadb-svc 8181:80