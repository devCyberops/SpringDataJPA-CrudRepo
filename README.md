# SpringDataJPA-CrudRepo
• Introduction DevOps (installation Virtual Box / Vagrant / CentOS)
• Jenkins (Serveur d’intégration continue)
• Git (Projet Spring Boot et Angular)
• Nexus (Gestion des livrables)
• Test unitaire (JUnit)
• Sonar (Qualité de code)
• Docker avancé (Docker compose + Docker volume)
• Grafana et Prometheus

L’Intégration Continue consiste à compiler, tester et déployer sur un environnement d’intégration: jenkins.(compilation: traduire les .java en .class, test et deploiement)

La Livraison Continue est un processus orienté production consistant à déployer manuellement sur un environnement donné (release ), output .jar (livraison du produit final.

• Le Déploiement Continu est un processus orienté production consistant à déployer automatiquement du jar sur tous les environnements(Docker Hub).

le DevSecOps consiste à sécuriser chaque "Stage" du pipeline de jenkins ) travers les phases de pre-commit(SonarQube), commit(JUnit, Retire JS), Acceptance(gauntlt, OWASP Zap), Production( Ansible Vault and DAST Zap), Operation phase(Grafana for continous Monitoring) ![arch](https://user-images.githubusercontent.com/47789008/202680118-e57ba8e9-842b-4423-8f5e-a255ba9080eb.jpg)
