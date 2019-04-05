# PathFinder

Pathfinder is a Java based app that can be used to find the shortest path between two vertices. It implements a Breadth First Search (BFS) algorithim.

## Running
To Run the application place a file named map.txt in the projects resource folder. The program will use the following legend:

* W - Obstacle or Wall
* . - Clear Path, ie one can move to this cell
* S - Start
* E - End
* \* - Path taken
* " - Visited

After a sucessfull run two new files will be created at the root of the project. input.txt will contain the ingested map which was used for processing, and output.txt which will contain the processed results.

## Sample Map
```
. . . . . . . . . . . . W . . . . . . . 
. . . . . . . . . . . . W . . . . . . .
. . . . . . . W . . . . W . . . . . . . 
W . W W . . . W . . . . W . W . . . . . 
S . . W . . . W W W W w W . W . . . . E 
W . W . W . . . . . . . W . W . . . . . 
. . . . W . . . . . . . W . W . . . . . 
. . . . W . . . . . . . . . W . . . . . 
. . . . . W . . . . . . . . W . . . . . 
. . . . . . W . . . . . . . W . . . . .
```
Contact: ntobekomkhize_at_yahoo_dot_com
