# sb-demo

## Run With Docker Desktop Kubernetes

This is the Kubernetes variant for the assignment.

Prerequisites:

- Docker Desktop is installed and running
- Kubernetes is enabled in Docker Desktop
- `kubectl` is using the `docker-desktop` context
- postgres:15 
```powershell
docker pull postgres:15
```

Check the context:

```powershell
kubectl config current-context
kubectl get nodes
```

Build the application image:

```powershell
cd sb-demo
docker build -t sb-demo:latest .
```

Deploy to Kubernetes:

```powershell
kubectl apply -f .\k8s\docker-desktop\manifest.yaml
kubectl get all -n sb-demo-dd
kubectl get pods -n sb-demo-dd -w
```

When the pods are running, open a second terminal and forward a local port:

```powershell
kubectl port-forward -n sb-demo-dd service/sb-demo 8081:8080
```

Test API:

```powershell
curl "http://localhost:8081/api/hello"
curl "http://localhost:8081/api/current-accounts/SK8975000000000012345671/transactions"
```

Remove the deployment only if you want to stop and clean everything:

```powershell
kubectl delete -f .\k8s\docker-desktop\manifest.yaml
```

If you close the `kubectl port-forward` terminal, the application keeps running in Kubernetes. Only the local forwarding stops.

## Run With Podman

```powershell
cd sb-demo
podman compose down -v
podman compose build --no-cache
podman compose up -d
```

Check running containers:

```powershell
podman compose ps
```

Test API:

```powershell
curl "http://localhost:8080/api/hello"
curl "http://localhost:8080/api/current-accounts/SK8975000000000012345671/transactions"
```

Stop:

```powershell
podman compose down
```
