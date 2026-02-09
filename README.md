# Selenium FERIT Tests

## ✨ Opis projekta

Ovaj projekt je osmišljen kao osnovni okvir za **automatsko testiranje web stranica** uz pomoć alata **Selenium WebDriver** i **TestNG**. Testira se web stranica **Demo Web Shop**. Testovi pokrivaju ključne funkcionalnosti web stranice kao što su **pretraživanje**, **prijava** i **dodavanje u košaricu**.

**URL testirane stranice:**  
[Demo Web Shop](https://demowebshop.tricentis.com/)

---

## 🔧 Tehnologije

| **Tehnologija**      | **Verzija**    | **Svrha**                                  |
|----------------------|----------------|--------------------------------------------|
| **Java JDK**         | 25.0.2         | Glavni programski jezik za razvoj          |
| **IntelliJ IDEA**    | Latest         | Integrirano razvojno okruženje             |
| **Google Chrome**    | 144.0.7559.133 | Test preglednik                            |
| **Chrome Driver**    | Isto kao Chrome| Alat za automatizaciju Chrome preglednika  |
| **Apache Maven**     | 3.9.12         | Upravljanje zavisnostima                   |

---

## 📝 Preduvjeti

Da bi ovaj projekt radio, potrebno je imati:

- **Apache Maven 3.9+**
- **Google Chrome** preglednik
- **Git**
- **IntelliJ IDEA**

---

## 🧪 Testni slučajevi

Projekt sadrži 5 automatiziranih testnih slučajeva:

1. **Provjera učitavanja Demo Web Shop stranice**
2. **Provjera prijave korisnika**
3. **Provjera navigacije na stranici**
4. **Test dodavanja elementa u košaricu**
5. **Test sortiranja i filtriranja**

---

## 🚀 Pokretanje testova

### 1. **Pokretanje testova u IntelliJ IDEA**

- Otvorite projekt u **IntelliJ IDEA**
- Desni klik na test klasu po želji ili na `testng.xml`
- Odaberite **Run** za pokretanje testova

### 2. **Pokretanje testova putem komandne linije**

U root direktoriju projekta pokrenite sljedeću komandu:

```bash
mvn test
