package br.com.stefanini.stefaninifood.service;

import br.com.stefanini.stefaninifood.model.Cliente;
import br.com.stefanini.stefaninifood.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarTodosClientes() {
        return this.clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return this.clienteRepository.findById(id).get();
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clientePorId = clienteRepository.findById(id).get();
        Cliente clienteAtualizado = new Cliente();

        BeanUtils.copyProperties(cliente, clienteAtualizado);
        clienteAtualizado.setId(clientePorId.getId());

        return this.clienteRepository.save(clienteAtualizado);
    }

    @Transactional
    public void removerCliente(Cliente cliente) {
        this.clienteRepository.delete(cliente);
    }

}
