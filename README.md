# Kontoappen

Länk till muntlig redovisning:
LÄGG IN VIDEOLÄNK HÄR SENARE

## Inkapsling

Jag har gjort owner och balance privata i Account-klassen. Det gör att de inte kan ändras direkt från andra delar av programmet. Istället använder jag metoder för att läsa och ändra informationen. Det gör till exempel att jag kan kontrollera att ett uttag inte gör saldot negativt.

## Skapa konto

Jag skapar nya konton genom AccountRegister istället för direkt i Main. Då hamnar alla nya konton i samma lista. Main behöver mest ta hand om menyn och det användaren skriver in.

## Flöde

När användaren väljer att sätta in pengar frågar programmet först efter ägarens namn. AccountRegister söker sedan efter kontot. Om kontot finns frågar programmet efter beloppet och kör deposit-metoden på kontot. Efter det visas det nya saldot.

## Reflektion

När jag har kört fast har jag försökt ta en sak i taget och testa programmet igen. Jag använde kursmaterialet och AI som hjälp när jag behövde förstå hur klasserna skulle arbeta tillsammans. Ett exempel var när jag behövde förstå varför AccountRegister ska skapa och hålla reda på kontona istället för att göra allt direkt i Main. Jag testade sedan programmet själv för att kontrollera att skapa konto, insättning och uttag fungerade.