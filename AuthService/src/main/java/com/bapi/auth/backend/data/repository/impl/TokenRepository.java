package com.bapi.auth.backend.data.repository.impl;

import com.bapi.auth.backend.data.entity.IdTokenEntity;
import com.bapi.auth.backend.data.repository.ITokenRepository;
import com.bapi.auth.backend.data.source.ITokenDataSource;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class TokenRepository implements ITokenRepository {
    private final String TAG = TokenRepository.class.getSimpleName();
    @Autowired
    private ITokenDataSource tokenEntityDao;
    @Autowired
    private IMapper<Token, IdTokenEntity> tokenEntityIMapper;

    @Override
    public Token findTokenByUserNameAndDeviceId(String deviceId, String userName) {
        Logger.getLogger(TAG).info("findTokenByUserNameAndDeviceId " + deviceId + " " + userName);
        return tokenEntityDao.findTokenByUserNameAndDeviceId(deviceId, userName)
                .map(tokenEntityIMapper::mapTo)
                .orElse(null);
    }

    @Override
    public Token findById(Long id) {
        Logger.getLogger(TAG).info("findById " + id);
        return tokenEntityDao.findById(id)
                .map(tokenEntityIMapper::mapTo)
                .orElse(null);
    }

    @Override
    public List<Token> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return tokenEntityDao.findAll().stream().map(tokenEntityIMapper::mapTo).collect(Collectors.toList());
    }

    @Override
    public Token save(Token token) {
        Logger.getLogger(TAG).info("save " + token);
        IdTokenEntity entity = tokenEntityIMapper.mapFrom(token);
        IdTokenEntity savedEntity = tokenEntityDao.save(entity);
        return tokenEntityIMapper.mapTo(savedEntity);
    }

    @Override
    public Token update(Token token, String... params) {
        Logger.getLogger(TAG).info("update " + token);
        IdTokenEntity entity = tokenEntityIMapper.mapFrom(token);
        IdTokenEntity updateEntity = tokenEntityDao.save(entity);
        return tokenEntityIMapper.mapTo(updateEntity);
    }

    @Override
    public boolean delete(Token token) {
        Logger.getLogger(TAG).info("delete " + token);
        IdTokenEntity entity = tokenEntityIMapper.mapFrom(token);
        tokenEntityDao.delete(entity);
        return true;
    }
}
