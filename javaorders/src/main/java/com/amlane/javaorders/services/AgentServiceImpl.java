package com.amlane.javaorders.services;

import com.amlane.javaorders.models.Agent;
import com.amlane.javaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value="agentService")
public class AgentServiceImpl implements AgentService
{
    @Autowired
    private AgentRepository agentrepos;

    @Override
    public List<Agent> findAll()
    {
        return null;
    }

    @Override
    public Agent findById(long id) throws EntityNotFoundException
    {
        return agentrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Agent save(Agent agent)
    {
        return null;
    }

    @Override
    public Agent update(Agent agent, long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }
}
