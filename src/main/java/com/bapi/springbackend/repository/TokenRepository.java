package com.bapi.springbackend.repository;

import com.bapi.springbackend.dao.IdTokenEntity;
import com.bapi.springbackend.dao.IdTokenEntityDao;
import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TokenRepository implements ITokenRepository {
    @Autowired
    private IdTokenEntityDao idTokenEntityDao;

    @Autowired
    private IMapper<Token, IdTokenEntity> idTokenEntityIMapper;
    @Autowired
    private IMapper<IdTokenEntity, Token> tokenIMapper;

    @Override
    public Token findById(String id) {
        return idTokenEntityDao.findById(id).map(tokenIMapper::mapFrom).orElse(null);
    }

    @Override
    public List<Token> findAll() {
        return StreamSupport.stream(idTokenEntityDao.findAll().spliterator(), false)
                .collect(Collectors.toList()).stream()
                .map(tokenIMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Token save(Token token) {
        return tokenIMapper.mapFrom(idTokenEntityDao.save(idTokenEntityIMapper.mapFrom(token)));
    }

    @Override
    public Token update(Token token, String... params) {
        return tokenIMapper.mapFrom(idTokenEntityDao.save(idTokenEntityIMapper.mapFrom(token)));
    }

    @Override
    public void delete(Token token) {
        idTokenEntityDao.deleteById(token.getDeviceUniqueId());
    }

    @Override
    public Token findTokenByUserNameAndDeviceId(String deviceId, String userName) {
        return idTokenEntityDao.findTokenByUserNameAndDeviceId(deviceId, userName)
                .map(tokenIMapper::mapFrom)
                .orElse(null);
    }
}
