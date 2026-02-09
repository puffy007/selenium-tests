\# Selenium FERIT Tests



\## Opis projekta

Ovaj projekt je napravljen kao osnovni okvir za automatsko testiranje web stranice uz pomoć alata Selenium WebDriver i TestNG. Testira se web stranica Demo Web Shop. Testovi pokrivaju ključne funkcionalnosti web stranice kao što su pretraživanje, prijava i dodavanje u košaricu.



\*\*URL testirane stranice:\*\* 

\[https://demowebshop.tricentis.com/](https://demowebshop.tricentis.com/)



---



\## Tehnologije



| Tehnologija         | Verzija        | Svrha                                     |

|---------------------|----------------|-------------------------------------------|

| Java JDK            |     25.0.2     | Glavni programski jezik za razvoj         |

| IntelliJ IDEA       |     Latest     | Integrirano razvojno okruženje            |

| Google Chrome       | 144.0.7559.133 | Test preglednik                           |

| Crome Driver        | Same as Chrome | Alat za automatizaciju Chrome preglednika |

| Apache Maven        |     3.9.12     | Upravljanje zavisnostima                  |



---



\## Preduvjeti

&nbsp;

\- Apache Maven 3.9+  

\- Google Chrome preglednik  

\- Git  

\- IntelliJ IDEA  



---



\## Testni slučajevi



Projekt sadrži 5 automatiziranih testnih slučajeva:  

1. Provjeru učitavanja Depo Web Shop stranice
2. Provjera prijave korisnika
3. Provjera navigacije na stranici
4. Test dodavanja elementa u košaricu
5. Test sortiranja i filtriranja



---



\## Pokretanje testova



\### 1. IntelliJ IDEA

\- Otvoriti projekt u IntelliJ aplikaciji

\- Desni klik na test klasu po želji ili `testng.xml`  

\- Odabrati \*\*Run\*\*  



\### 2. Komandna linija

U root direktoriju projekta pokrenuti:



mvn test



---



\## Rezultat testova

Kada se testovi izvrše može se pronaći izvješće na lokaciji: target/surefire-reports/index.html





