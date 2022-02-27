## Group members
&nbsp;

| NMec | Name | email | Contribution (%) | Detailed contribution [1]
|:-:|:--|:--|:-:|:--|
| 98391 | Vasco Santos | vascovsantos@ua.pt | 20% | primary-grammar-planning (16.7%)<br>seamantic-check (60%)|
| 43889 | Joao Moura   | jjmoura@ua.pt | 28% |  primary-grammar-planning (16.7%)<br>primary-grammar (38%)<br>examples (50%)<br>testing (50%)<br>Report and Organizing Git (50%)|
| 89131 | Leonardo Freitas | leonardofreitas99@ua.pt | 10% |  primary-grammar-planning (16.7%)<br>primary-grammar (4%)<br>Report and some help on Git (50%)|
| 98152 | Goncalo Sousa | goncalo.sousa@ua.pt | 2% |  primary-grammar-planning (16.7%)|
| 97688 |Ruben Castelhano | rubencastelhano@ua.pt | 38% | primary-grammar-planning (16.7%)<br>primary-grammar (58%)<br>examples (50%)<br>testing (50%)<br>secondary-language (100%)<br> semantic-check (40%)|
| 98158 | Pedro Santos | pedrofpsantos@ua.pt | 2% | primary-grammar-planning (16.7%)


## Material to be evaluated

- All the material to be evaluated is in the master branch. The src folder has all the source code of BdeX, the examples folder has some examples and the 
doc folder has Report document that explains in detail, in portuguese, the syntax and the language BdeX.

## Compilation & Run

- To try our program just run in the command line ./compile to primarily check for errors (an output is only generated if no errors are detected), then run ./run to start the program. 

- Any errors occured because of the commands just do sudo chmod +x compile run

- To do a clean up just use the clean command


## Working examples (at least two)

To use our examples with the compile command just use this paths.

1. `../examples/example1.bdex`

    An example with creation of a table named music and insertion of things related to the world of music. Then extract to a new table named metal, all the 
    metal genre type of music. Created a column named metal_genre for the subtypes of metal. Inserted that column into the metal table and finnaly printed and saved
    the tables.


2. `../examples/example3.bdex`

    An example that creates a table called Alunos with classes, inserted the names of the students and their score. Read from AlunosTable.table and then join
    both tables. Displays the joined table. Then students who failed "AlgC" get removed and the table is displayed again.

3. `../examples/example4.bdex`
    
    A library example. A table named library is created. The program then fills 3 lines with input from the user. The table is then displayed in the terminal.
    A new text column is created and inserted into the table with the column name being given by the user. The new column is then filled with 3 elements inputed by the user. 
    The column is then joined into the table and the table is displayed again. The column "NCopias" is then removed from the table and the table is displayed again.
    

4. `../examples/test.bdex`

    Not a real example (has semantic errors). Used during grammar development to test if everything was being parsed correctly.
## Semantic error examples

1. `../examples/semanticCheckShowcase.bdex`

    A detailed explanation of what's wrong is commented line-by-line in the file itself.
    Semantic check is automatically compiled when running the compile shell file in the src directory of the repository.
    An output is only produced when no semantic error is detected.

...
