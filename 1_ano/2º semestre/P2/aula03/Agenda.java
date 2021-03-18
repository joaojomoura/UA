import static java.lang.System.*;

public class Agenda {
    private Tarefa [] task = new Tarefa[1000];
    private int n = 0;

    public Tarefa [] novaTarefa (Tarefa task) {
        this.task[n] = task;
        n++;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < this.task.length && this.task[j]!= null; j++) {
              if (this.task[j].inicio().compareTo(this.task[i].inicio()) < 0) {
                Tarefa tmp = this.task[j];
                this.task[j] = this.task[i];
                this.task[i] = tmp;
              }
            }
          }
        return this.task;
    }


    public void escreve(){
        for(int i = 0; i < n; i++) {
            out.println(task[i].toString());
        }
    }
    
}