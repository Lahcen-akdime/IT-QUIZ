# IT-QUIZ 🎓

Plateforme web intelligente de préparation aux certifications IT

---

## 📋 Présentation du projet

**IT-QUIZ** est une plateforme web intelligente de préparation aux certifications IT. L'application permet aux utilisateurs de choisir une certification, de générer automatiquement des quiz grâce à une intelligence artificielle, de répondre aux questions, d'obtenir une correction intelligente et de suivre leur progression.

### Ce que vous pouvez faire sur IT-QUIZ :
- ✅ Choisir une certification
- ✅ Générer automatiquement des quiz grâce à l'IA
- ✅ Répondre aux questions
- ✅ Obtenir une correction intelligente
- ✅ Suivre votre progression

### Certifications supportées :
- AWS
- Cisco
- Red Hat
- Security+
- Et bien d'autres...

### Stack technologique :
- **Full Stack Development** : Java/Spring Boot + Angular
- **Intelligence Artificielle** : Génération et correction automatique
- **Cybersécurité défensive** : Protection web complète
- **Architecture moderne** : Java Angular

---

## 🎯 Objectifs du projet

### 2.1 Objectifs techniques
- Développer une API REST avec Java Spring Boot
- Développer une interface moderne avec Angular
- Intégrer une API AI pour la génération des quiz
- Sécuriser l'application avec Spring Security et JWT
- Utiliser PostgreSQL pour le stockage des données
- Implémenter des fonctionnalités de cybersécurité défensive

### 2.2 Objectifs pédagogiques
- Comprendre l'architecture frontend/backend
- Comprendre l'intégration des AI & API's
- Comprendre les bases de la cybersécurité web
- Apprendre Java Spring Boot
- Apprendre Angular
- Construire une application réelle orientée EdTech

---

## 💻 Technologies utilisées

### Frontend
- Angular
- HTML / CSS
- TypeScript

### Backend
- Spring Boot
- Java
- Spring Security
- JWT Authentication

### Base de données
- PostgreSQL

### Intelligence Artificielle
- Google Gemini API

---

## ✨ Fonctionnalités principales

### 4.1 Authentification et utilisateurs

#### 📝 Inscription
- Création de compte avec nom, email, mot de passe

#### 🔐 Connexion
- Connexion sécurisée avec JWT
- Mot de passe hashé (bcrypt)

#### 🚪 Déconnexion
- Suppression du token utilisateur

#### 👥 Gestion des rôles
- **USER** : Utilisateur standard
- **ADMIN** : Administrateur de la plateforme

### 4.2 Gestion des certifications

#### 📚 Liste des certifications
Affichage de toutes les certifications disponibles :
- AWS
- Cisco
- Red Hat
- Security+

#### 📖 Consultation des certifications
Affichage détaillé :
- Description
- Niveau
- Catégorie
- Compétences associées

### 4.3 Génération AI de quiz

#### 🤖 Génération automatique
L'IA génère automatiquement :
- Questions pertinentes
- Choix de réponses
- Réponses correctes
- Niveaux de difficulté

#### ⚙️ Paramètres quiz
L'utilisateur peut choisir :
- Certification
- Niveau de difficulté
- Nombre de questions

#### 📌 Exemple de génération
```
Entrée utilisateur : AWS - Beginner - 5 questions

Résultat AI :
Question 1: What is Amazon S3?
A) Simple Storage Service
B) Simple Security Service
C) Secure Storage Service
D) System Storage Service
```

### 4.4 Correction intelligente

#### ✅ Correction automatique
Le système corrige :
- Réponses correctes
- Réponses incorrectes

#### 💡 Explication AI
L'IA explique :
- Pourquoi la réponse est correcte
- Pourquoi la réponse est fausse

### 4.5 Suivi progression

#### 📊 Calcul des scores
Le système calcule :
- Score total
- Pourcentage de réussite
- Historique des résultats

#### 📈 Dashboard utilisateur
Affichage :
- Progression globale
- Certifications travaillées
- Scores précédents
- Statistiques des quiz

---

## 🔒 Fonctionnalités cybersécurité défensive

### 5.1 Sécurité authentification

#### 🔑 Hash des mots de passe
- Utilisation de bcrypt pour le stockage sécurisé

#### 🎫 JWT
- Protection des routes API
- Validation des tokens

#### ⏱️ Expiration des tokens
- Sessions limitées dans le temps

### 5.2 Validation des données

#### ✔️ Validation frontend
Angular vérifie :
- Email valide
- Champs obligatoires
- Taille minimale

#### ✔️ Validation backend
Spring Boot valide toutes les données reçues

### 5.3 Protection contre attaques web

#### 🛡️ Protection XSS
- Nettoyage des données utilisateur
- Echappement des caractères spéciaux

#### 🛡️ Protection SQL Injection
- Utilisation sécurisée de JPA/Hibernate
- Requêtes paramétrées

#### 🛡️ Protection brute force
- Blocage temporaire après plusieurs connexions échouées

### 5.4 Logs sécurité
Le système enregistre :
- Connexions
- Erreurs
- Activités suspectes
- Accès refusés

---

## 🏗️ Architecture générale

```
┌─────────────────────────────────────────┐
│         FRONTEND (Angular)              │
├─────────────────────────────────────────┤
│ Components | Services | Routing         │
│ Guards | Dashboard                      │
└────────────────┬────────────────────────┘
                 │ REST API
┌────────────────▼────────────────────────┐
│       BACKEND (Spring Boot)             │
├─────────────────────────────────────────┤
│ Controllers | Services | Repositories   │
│ DTOs | Security Layer | AI Service      │
└────────────────┬────────────────────────┘
                 │
    ┌────────────┼────────────┐
    │            │            │
┌───▼───┐  ┌────▼─────┐  ┌──▼──────┐
│PostgreSQL │  AI API  │  │  Logs   │
└─────────┘  └──────────┘  └─────────┘
```

### Frontend
- **Angular** : Components, Services, Routing, Guards sécurité, Dashboard

### Backend
- **Spring Boot** : Controllers, Services, Repositories, DTO, Security Layer, AI Service

### Database
- **PostgreSQL** : Users, Roles, Certifications, Quizzes, Questions, Results, Logs

### AI Layer
- Communication avec API AI
- Génération de quiz
- Correction intelligente
- Explication des réponses

---

## 📦 Structure des modules

### Module Auth
- Register (inscription)
- Login (connexion)
- JWT (tokens)
- Rôles (USER, ADMIN)

### Module Certifications
- Liste des certifications
- Détails des certifications

### Module Quiz
- Génération AI de quiz
- Réponses utilisateur
- Correction
- Score

### Module Progression
- Historique des résultats
- Statistiques
- Progression utilisateur

### Module Security
- Validation des données
- Logs
- Monitoring
- Protection d'accès

---

## 🖥️ Interfaces principales

| Page | Description |
|------|-------------|
| **Login** | Connexion utilisateur |
| **Register** | Création de compte |
| **Dashboard** | Statistiques et progression |
| **Certifications** | Liste des certifications disponibles |
| **Quiz** | Affichage des questions et réponses |
| **Result** | Correction intelligente et score |
| **Admin Panel** | Gestion utilisateurs et logs sécurité |

---

## 🎓 Résultats attendus

À la fin du projet, vous aurez :

✅ Une application **full stack fonctionnelle**
✅ Génération **AI quiz opérationnelle**
✅ **Correction intelligente** opérationnelle
✅ **Suivi progression** fonctionnel
✅ **Sécurité web** implémentée
✅ Maîtrise de **Java Spring Boot et Angular**
✅ Compréhension de l'**intégration AI**
✅ Compréhension de la **cybersécurité défensive**

---

## 🚀 Évolutions futures possibles

### 🤖 AI avancée
- Chatbot pédagogique
- Génération d'examens complets
- Recommandations automatiques

### 🔐 Cybersécurité avancée
- Authentification 2FA
- Monitoring avancé
- Audit sécurité

---

## 📝 License

Ce projet est sous licence MIT.

---

## 👨‍💻 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à ouvrir des issues ou des pull requests.

---

**Dernière mise à jour** : Juin 2026
