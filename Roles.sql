Roles
    -- ADMIN
    -- CUSTOMER 
    -- SELLER

USER
    -- ID
    -- FULLNAME
    -- EMAIL
    -- PASSWORD
    -- ROLE ( 1 - 1 MAPPING) (ENUM)
    -- CREATED_AT

CATEGORY  --------------------
    -- ID                     | 
    -- NAME
    -- SLUG
    -- DESCRIPTION
    -- CREATED_AT           

PRODUCT--------------------
    -- ID                     | 
    -- title
    -- DESCRIPTION
    -- price
    -- stock
    -- category ( M - 1 Mapping with category)
    -- seller (M - 1 Mapping with user)
    -- CREATED_AT
    -- UPDATED_AT

PRODUCT_IMAGE-----------------
    -- ID                     | 
    -- URL
    -- PRIMARIMAGE
    -- SORTORDER
    -- PRODUC (M-1 MAPPING WITH PRODUCT)
    -- CREATED_AT

CART ------------------------
    -- ID                     |
    -- CUSTOMER (M - 1 MAPPING WITH USER


CART_ITEM
    -- ID
    -- QUANTITY
    -- CART_ID (M - 1 MAPPING WITH CART)
    -- PRODUCT_ID (M - 1 MAPPING WITH PRODUCT)

SHIPPING_ADDRESS
    -- ID
    -- CUSTOMER (M - 1 MAPPING WITH USER)
    -- ADDRESS_LINE1
    -- ADDRESS_LINE2
    -- CITY
    -- STATE
    -- ZIP_CODE
    -- COUNTRY
    -- PHONE_NUMBER

ORDER 
    -- ID
    -- CUSTOMER (M - 1 MAPPING WITH USER)
    -- TOTAL_AMOUNT
    -- STATUS (ENUM: PENDING, PROCESSING, COMPLETED, CANCELLED)
    -- SHIPPING_ADDRESS (M - 1 MAPPING WITH SHIPPING_ADDRESS)
    -- CREATED_AT
    -- UPDATED_AT

ORDER_ITEM
    -- ID
    -- ORDER_ID (M - 1 MAPPING WITH ORDER)
    -- PRODUCT_ID (M - 1 MAPPING WITH PRODUCT)
    -- QUANTITY
    -- PRICE

PAYMENT
    -- ID
    -- ORDER_ID (M - 1 MAPPING WITH ORDER)
    -- AMOUNT
    -- PAYMENT_METHOD (ENUM: CREDIT_CARD, PAYPAL, BANK_TRANSFER)
    -- PAYMENT_PROVIDER (ENUM: STRIPE, PAYPAL, SQUARE)
    -- STATUS (ENUM: PENDING, COMPLETED, FAILED)
    -- TRANSACTION_ID
    -- RAW_RESPONSE
    -- CREATED_AT
    -- UPDATED_AT
