DROP TABLE IF EXISTS opportunities;

CREATE TABLE opportunities(opportunity_id VARCHAR(255) PRIMARY KEY, code VARCHAR(255),  partner_id VARCHAR
(255), title VARCHAR(255), short_desc TEXT, tags TEXT, investment_type VARCHAR(255), payout_schedule VARCHAR(255),
irr_pretax DOUBLE PRECISION, irr_postax DOUBLE PRECISION, minimum_investment INTEGER, tenure_in_days INTEGER,
total_capital DOUBLE PRECISION, current_progress  DOUBLE PRECISION, current_status VARCHAR(255), currency VARCHAR(255),
createdontimestamp TIMESTAMP, lastupdatedtimestamp TIMESTAMP);



DROP TABLE IF EXISTS partners;

CREATE TABLE partners(partner_id VARCHAR(255) PRIMARY KEY, name VARCHAR(255),  url VARCHAR
(255), referral_code VARCHAR(255), partner_desc TEXT, investment_types TEXT, minimum_investment INTEGER,
createdontimestamp TIMESTAMP, lastupdatedtimestamp TIMESTAMP);

