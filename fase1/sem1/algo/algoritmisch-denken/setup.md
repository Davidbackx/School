# Setupinstructies (eenmalig uit te voeren)

* Voor dit vak heb je Git, NodeJS en Chrome nodig (FireFox zou ook moeten werken, maar werd niet getest. Edge geeft sowieso problemen.) Indien deze nog niet geïnstalleerd zijn,
  volg de instructies op [deze site](https://ucleuvenlimburg.github.io/software/).
* Maak een directory aan waar je je cursusmateriaal voor dit vak wil bewaren.
* Open een consolevenster in deze directory.
  * Windows: open Windows Explorer/Verkenner, ga naar de folder, rechterklik en kies "Git Bash Here".
  * MacOS: In SpotLight, typ `terminal`. Ga naar de juiste directory. Als je niet weet hoe, vraag om begeleiding.
* Voer in:
  * Windows: `npm install -g UCLeuvenLimburg/algoritmisch-denken-cli`
  * MacOS: `sudo npm install -g UCLeuvenLimburg/algoritmisch-denken-cli`
* In een browser: ga naar [GitHub Classroom](https://classroom.github.com/a/eCaxzVOb).
* Aanvaard de assignment.
* Wacht tot GitHub klaar is met je repository te initialiseren. Er zijn 2 progress bars: beide moeten op 100% staan eer je verder gaat. Dit kan een tijdje duren (kan variëren van 1 tot 10 minuten of misschien zelfs meer in uitzonderlijke gevallen.)
* Noteer de getoonde URL. Deze is van de vorm `https://github.com/algoritmisch-denken-oefeningen-1920/ad1920-LOGIN` waarbij LOGIN je GitHub-login is.
* Ga terug naar de console. Voer in: `algo initialize URL` waarbij URL het adres is dat je in de vorige stap verkreeg. Dit zou in principe slechts enkele seconden moeten duren. Als het langer duurt, wacht je best enkele minuten vooraleer je opnieuw probeert. Als het niet lukt, haal je best de lector erbij.

Je kan nu oefeningen maken zoals [hier](usage.md) beschreven.

## Noodoplossing

Dit staat hier enkel vermeld om studenten met lastige problemen toch te kunnen laten beginnen terwijl er naar een betere oplossing gezocht wordt. Dit is slechts een tijdelijke oplossing en zou je normaalgezien niet nodig moeten hebben.

```
git clone https://github.com/UCLeuvenLimburg/algoritmisch-denken-oefeningen.git algoritmisch-denken-temp
```
