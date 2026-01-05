# Vue 3 + TypeScript + Vite

This template should help get you started developing with Vue 3 and TypeScript in Vite. The template uses Vue 3 `<script setup>` SFCs, check out the [script setup docs](https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup) to learn more.

Learn more about the recommended Project Setup and IDE Support in the [Vue Docs TypeScript Guide](https://vuejs.org/guide/typescript/overview.html#project-setup).


## VSAS (Vertaling SAP/S4HANA)
Deze applicatie is ontwikkeld om een idee te geven hoe het toekomstige systeem bij het liaison office in Luxemburg, Capellen dient te functioneren. Dit in de vorm van een prototype. Zie het bijgevoegde adviesoducment voor met uitleg over het idee.
Het project is een stageopdracht bedoeld voor de Nederlandse vertegenwoordigers bij NSPA.

## Vereisten
- Node.js v22.14.0+
- Git

Ik heb WebStorm gebruikt voor frontend

## Installatie
1. Clone de repository
```bash
git clone https://github.com/SquidgyPants/VSAS.git
```
2. Ga naar de juiste map
```bash
cd VSAS
cd frontend
npm install
```

## VEREIST
Open in de editors de juiste mappen
Backend: VSAS/backend
Frontend: VSAS/frontend

Dit doe je omdat je anders geen run configuration krijgt.

3. Belangrijke installaties
Zorg dat je de Maven sources en documentation download, anders werken de plugins niet.
```bash
mvn clean-install
```

4. Applicatie starten

```bash
npm run dev
```

5. Controleer of applicatie gestart is
http://localhost:8080/swagger-ui/index.html#


## Projectstructuur
/src -> API.ts voor backend endpoints
/src/components -> verschillende pagina's voor de applicatie

## Bekende beperkingen
- Deze applicatie werkt alleen lokaal EN als de backend applicatie draait


## Auteur
Kars Vestjens - ICT - Fontys
Dit project is ontwikkeld als onderdeel van de derde jaars stage