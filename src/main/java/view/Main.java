package view;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            emf = Persistence.createEntityManagerFactory("GestaoEventos");
            
            em = emf.createEntityManager();
            
            System.out.println("✓ Conexão com o banco de dados estabelecida com sucesso!");
            
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("✓ Transação de teste executada com sucesso!");
            
        } catch (Exception e) {
            System.err.println("✗ Erro ao conectar com o banco de dados:");
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            System.out.println("Recursos liberados.");
        }
    }
}