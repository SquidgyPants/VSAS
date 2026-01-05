## VSAS (Vertaling SAP/S4HANA)
Deze applicatie is ontwikkeld om een idee te geven hoe het toekomstige systeem bij het liaison office in Luxemburg, Capellen dient te functioneren. Dit in de vorm van een prototype. Zie het bijgevoegde adviesoducment voor met uitleg over het idee.
Het project is een stageopdracht bedoeld voor de Nederlandse vertegenwoordigers bij NSPA.

## Vereisten (Zie pom.xml)
- Amazon Coretto 17.0.14
- Java 17
- Node.js v22.14.0+
- Git
- Database op eigen manier. Eventueel integratie, SQL database of textdocument.

Ik heb IntelliJ IDEA gebruikt voor backend

## Installatie
1. Clone de repository
```bash
git clone https://github.com/SquidgyPants/VSAS.git
```
2. Ga naar de juiste map

```bash
cd VSAS
cd backend
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

src/java.com.example/BackendApplication.java runnen


5. Controleer of applicatie gestart is
http://localhost:5173/


## Projectstructuur
/src -> broncode
/src/tests -> testbestanden
/src/main -> classes en startapplicatie

## Bekende beperkingen
- Deze applicatie werkt alleen lokaal
- Er mist een database buiten fontys workspace. Er moet dus een database aan gekoppeld worden met een connectionstring in application.properties.


## Auteur
Kars Vestjens - ICT - Fontys
Dit project is ontwikkeld als onderdeel van de derde jaars stage