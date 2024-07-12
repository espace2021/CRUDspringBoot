# deploy.ps1

# Arrêter l'application en cours d'exécution (si nécessaire)
Write-Host "Arrêt de l'application en cours..."
Stop-Process -Name java -Force -ErrorAction SilentlyContinue

# Copier le nouvel artefact (JAR) vers le répertoire de déploiement
Write-Host "Copie du nouvel artefact..."
Copy-Item -Path "target\mon-application.jar" -Destination "D:\Sandra\mon-application.jar" -Force

# Démarrer l'application
Write-Host "Démarrage de la nouvelle version de l'application..."
Start-Process -FilePath "java" -ArgumentList "-jar D:\Sandra\mon-application.jar" -NoNewWindow -RedirectStandardOutput "C:\path\to\deployment\mon-application.log" -RedirectStandardError "C:\path\to\deployment\mon-application.log"

Write-Host "Déploiement terminé."

