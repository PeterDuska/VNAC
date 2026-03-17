# sb-demo

Run with Podman:

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
