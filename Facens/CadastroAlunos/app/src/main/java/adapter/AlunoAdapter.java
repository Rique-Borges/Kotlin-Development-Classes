package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cadastroalunos.R;
import java.util.List;

import model.Aluno;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder> {

    private List<Aluno> listaAlunos;

    public AlunoAdapter(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aluno, parent, false);
        return new AlunoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {
        Aluno aluno = listaAlunos.get(position);
        holder.tvNomeAluno.setText(aluno.getNome());
        holder.tvRAAluno.setText("RA: " + aluno.getRa());
    }

    @Override
    public int getItemCount() {
        return listaAlunos.size();
    }

    static class AlunoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeAluno, tvRAAluno;

        public AlunoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomeAluno = itemView.findViewById(R.id.tvNomeAluno);
            tvRAAluno = itemView.findViewById(R.id.tvRAAluno);
        }
    }
}
