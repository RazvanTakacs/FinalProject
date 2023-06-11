# Documentație FinalProject

Proiectul este reprezentat de o suită de teste automate implementate pentru verificarea și validarea unei pagini web. Pagina testată este un mediu interactiv de explorare a capabilităților framework-ului Selenium.
Proiectul este creat utilizând design pattern-ul Page Object Model. 

Acest design pattern este utilizat în procesul de testare automată pentru reducerea procentului de duplicare a codului și pentru simplificarea procesului de mentenanță. Presupune implementarea unei clase pentru fiecare pagină web în care se definesc metode și proprietăți corespunzătoare elementelor de pe pagină, oferind o interfață de control între test case-uri și obiecte de pagină ( page objects ).

Suita de teste este implementată în Java folosind framework-ul Selenium WebDriver. Această colecție de librării facilitează automatizarea acțiunilor pe o pagină web, prin expunerea unui set de clase, metode și proprietăți pentru controlarea programatică a paginii.

Pentru integrarea și execuția testelor în mediul de dezvoltare s-a folosit framework-ul TestNG. Acesta permite scrierea și executarea în mod organizat și eficient, oferind modalități de anotare, grupare și parametrizare a testelor.

Suita de teste folosește Chrome Driver pentru a deschide paginile web în browser-ul Chrome pe perioada execuției. Datorită anotărilor “@BeforeMethod” și “@AfterMethod” instanța de Chrome Driver se pornește înainte și se distruge după fiecare test.

Dependințele proiectului sunt descrise în fisierul pom.xml, fiecare nod având o structură specifică, bazată pe numele și versiunea framework-ului utilizat.

Proiectul este format din două subdirectoare: pages si testCases.

În directorul pages se găsesc clasele aferente paginilor web. Elementele din interfață sunt expuse și controlate utilizând metodele implementate în aceste clase. Identificarea elementelor din pagină se realizează cu ajutorul locatorilor.

În directorul testCases se găsesc suitele de teste grupate bazat pe elementul testat. Fiecare test case creează o instanță a paginii de control aferente elementului testat. Ordinea executiei testelor este controlată folosind anotări de tip “priority”.

Testele se pot executa în totalitate sau independent folosind IDE-ul InteliJ, obtinându-se un raport detailat la final.

Pentru rularea testelor trebuie modificat path-ul către Chrome Driver in funcția “setUp” a clasei “BasePage”. În aceeași locație se poate verifica și URL-ul paginii web testate (https://www.lambdatest.com/selenium-playground/).
